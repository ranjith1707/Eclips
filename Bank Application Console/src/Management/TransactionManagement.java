package Management;

import accounts.*;
import java.time.format.*;
import java.time.*;

import control.DatabaseController;
import control.UserControl;

public class TransactionManagement {
	private DatabaseController dataInsertion = new DatabaseController();
	UserControl userControl = new UserControl();

	protected void AmountTransfer(long senderAccountNumber, long reciver, double balance, String type) {

		long accountNumber = senderAccountNumber;
		long reciverAccountNumber = reciver;
		double amount = balance;
		LocalDate date = LocalDate.now();
		String dateOfTransaction = date.toString();
		LocalTime time = LocalTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		String timeOfTransaction = time.format(myFormatObj);
		String status;
		if (type.equals("AccountTransfer")) {
			status = "Account Transfer";
			amountCreaditAndDebit(accountNumber, reciverAccountNumber, amount);
			System.out.println("Amount Successfully Transferd *  ");
		} else {
			status = type;
			if (status.equals("Deposit")) {
				amountCreaditAndDebit(0, accountNumber, amount);
				System.out.println("Amount Credited ! ");
			} else if (status.equals("Withdraw")) {
				amountCreaditAndDebit(accountNumber, 0, amount);
				System.out.println("Amount Debited ! ");
			}

		}

		BankDatabase.getDatabase().setTransactionHistory(new Transactions(accountNumber, dateOfTransaction,
				timeOfTransaction, reciverAccountNumber, amount, status));
		dataInsertion.dataInsert(
				"insert into transaction_History(accountNumber,date,time,reciverNumber,amount,status)values("
						+ accountNumber + ",'" + dateOfTransaction + "','" + timeOfTransaction + "',"
						+ reciverAccountNumber + "," + amount + ",'" + status + "');");

	}

	private void amountCreaditAndDebit(long accountNumber, long reciverAccountNumber, double amount) {

		for (Costomer account : BankDatabase.getDatabase().getCostomers()) {
			if (accountNumber == account.getAccountNumber()) {
				double remains = account.getAccountBalance() - amount;
				account.setAccountBalance(remains);
				dataInsertion.dataInsert("update accountDetails set accountBalance=" + remains + " where accountNumber="
						+ accountNumber + "");

			}
			if (reciverAccountNumber == account.getAccountNumber()) {
				double remainder = account.getAccountBalance() + amount;
				account.setAccountBalance(remainder);
				dataInsertion.dataInsert("update accountDetails set accountBalance=" + remainder
						+ " where accountNumber=" + reciverAccountNumber + "");

			}
		}
	}
}
