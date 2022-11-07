package control;

import accounts.Costomer;
import accounts.Transactions;

import java.sql.ResultSet;
import java.sql.Statement;

import Management.BankDatabase;

public class DatabaseController {
	public void dataInsert(String insertQuery) {
		try {
			Statement statement = DatabaseConnection.getStatement();
			int insert = statement.executeUpdate(insertQuery);
		} catch (Exception e) {
			System.out.println("Data Not Inserted ! ");
		}
	}

	private ResultSet dataRetrived(String retriveData) {
		ResultSet datas = null;
		try {
			Statement statement = DatabaseConnection.getStatement();
			datas = statement.executeQuery(retriveData);

		} catch (Exception e) {
			System.out.println("Surver Busy ! ");
			e.printStackTrace();

		}
		return datas;

	}

	public void dataTransfer() {
		String dataQuery = " select costomerDetails.*,accountDetails.accountBalance,accountDetails.pinNo from costomerDetails join accountDetails on costomerDetails.accountNumber=accountDetails.accountNumber;";
		String transactionQuery = "select * from transaction_History ;";
		try {
			ResultSet datas = dataRetrived(dataQuery);
			while (datas.next()) {

				BankDatabase.getDatabase()
						.setCostomers(new Costomer(datas.getLong("accountNumber"), datas.getString("Name"),
								datas.getString("accountType"), datas.getString("branchName"),
								datas.getString("branchId"), datas.getString("dateOfBirth"),
								datas.getDouble("accountBalance"), datas.getString("pinNo")));
			}

			datas = dataRetrived(transactionQuery);
			while (datas.next()) {
				BankDatabase.getDatabase()
						.setTransactionHistory(new Transactions(datas.getLong("accountNumber"),
								datas.getString("date"), datas.getString("time"), datas.getLong("reciverNumber"),
								datas.getDouble("amount"),datas.getString("status")));
			}
			System.out.println("Transaction");
		} catch (Exception e) {
			System.out.println("Data not Transferd ! ");
			e.printStackTrace();
		}
	}

	public long getAccountNumber() {
		String dataQuery = "select Max(accountNumber)as accountNumber from costomerDetails;";
		long accountNumber = 0;
		try {
			ResultSet datas = dataRetrived(dataQuery);
			datas.next();
			accountNumber = datas.getLong("accountNumber");
		} catch (Exception e) {
			System.out.println("Account number No Fount  ! ");
			e.printStackTrace();
		}
		return accountNumber;
	}

}
