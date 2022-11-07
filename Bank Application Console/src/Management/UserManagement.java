package Management;

import java.time.LocalDate;
import java.time.Period;

//import accounts.AccountDatas;
import accounts.Costomer;
import accounts.Transactions;
//import banking.AccountTransfer;
//import banking.DashBoard;

public class UserManagement {
	public int getAge(String age) {
		try {
			LocalDate dob = LocalDate.parse(age);
			LocalDate currentDate = LocalDate.now();
			return Period.between(dob, currentDate).getYears();

		} catch (Exception e) {
			System.out.println("Enter DOB in 'YYYY-MM-DD'   format ");
		}
		return 0;
	}

	protected void viewProfile(long accountNumber) {
		boolean flag = true;
		for (Costomer balance : BankDatabase.getDatabase().getCostomers()) {
			if (balance.getAccountNumber() == accountNumber) {
				flag = false;
				System.out.println("Account Number : " + accountNumber);
				System.out.println("Name           : " + balance.getName());
				System.out.println("Account Type   : " + balance.getAccountType());
				System.out.println("Branch Name    : " + balance.getBranchName());
				System.out.println("Branch Id      : " + balance.getBranchId());
				System.out.println("Age            :" + getAge(balance.getDateOfBirth()));
				 return;
			}
		}
		if (flag)
			System.out.println("User Not Fount ! ");
        
	}

	protected void viewBalance(long accountNumber) {
		for (Costomer balance : BankDatabase.getDatabase().getCostomers()) {
			if (balance.getAccountNumber() == accountNumber) {
				System.out.println("Account Number : " + accountNumber);
				System.out.println("Balance        : " + balance.getAccountBalance());
				return;
			}
		}
	}

	protected void transactionHistory(long accountNumber) {

		System.out.println("<    All Statements   >\n");
		if (!BankDatabase.getDatabase().getTransactionHistory().isEmpty()) {
			System.out.printf("%15s %15s %20s %20s %34s %20s", "From", "To", " Time", "Date", "Transaction Amount",
					"status");
			System.out.println();

			System.out.println();
			for (Transactions transactionHistory : BankDatabase.getDatabase().getTransactionHistory()) {
				if (transactionHistory.getAccountNumber() == accountNumber) {
					System.out.printf("%20s|%18s|%20s|%20s|%20s|%25s", transactionHistory.getAccountNumber(),
							transactionHistory.getReciverAccountNumber(), transactionHistory.getTime(),
							transactionHistory.getDate(), transactionHistory.getAmount(),
							transactionHistory.getStatus());
					System.out.println();

				}

			}
			return;
		} else {
			System.out.println("No Transaction   fount   !");
		}

	}
}
