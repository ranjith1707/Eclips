package Management;

import java.util.*;
import control.UserControl;
import accounts.Costomer;
import accounts.CreateNewAccount;

public class AccountManagement {
	Scanner scanner = new Scanner(System.in);
	private TransactionManagement transfer = new TransactionManagement();
	UserControl userControl = new UserControl();
	CreateNewAccount createAccount = new CreateNewAccount();
	UserManagement userManage = new UserManagement();

	public void display() {
		System.out.println("________________________________________________________________\n");
		System.out.println(
				" 1 > New Account \n 2 > view Costomer Details\n 3 > deposit Balanse\n 4 >  Balance Withdrowal\n 5 > Account Transfer\n 6 > Exit");
		
		String option = scanner.nextLine();
		long accountNumber;
		double amount;
		try {
		switch (option) {
		case "1":
			createAccount.access();
			break;
		case "2":
			System.out.println("Enter Account Number : ");
			accountNumber = scanner.nextLong();
			userManage.viewProfile(accountNumber);
			break;
		case "3":
			System.out.println("Enter Account Number :");
			accountNumber = scanner.nextLong();
			System.out.println("Enetr Amount : ");
			amount = scanner.nextDouble();
			transfer.AmountTransfer(accountNumber, 0, amount, "Deposit");
			;
			break;
		case "4":
			System.out.println("Enter Account Number :");
			accountNumber = scanner.nextLong();
			System.out.println("Enetr Amount : ");
			amount = scanner.nextDouble();
			transfer.AmountTransfer(accountNumber, 0, amount, "Withdraw");
			;
			break;
		case "5":
			System.out.println("Enter Account Number :");
			accountNumber = scanner.nextLong();
			accountTransfer("pin", accountNumber);
			break;
		}
		
		
		
		}catch(Exception e) {
			System.out.println("Wrong Input");
			e.toString();
			
		}
		
		if(option!="6") {
			display();
		}
		
	}

	public void display(String pin, long accountNumber) {
		System.out.println("________________________________________________________________\n");
		System.out.println(
				" 1 >view account Balance \n 2 > view Profile\n 3 > Account Transfer\n 4 > View Statements\n 5 > Logout ");
		String option = scanner.nextLine();

		switch (option) {
		case "1":
			viewBalance(pin, accountNumber);
			break;
		case "2":
			userManage.viewProfile(accountNumber);
			break;
		case "3":
			accountTransfer(pin, accountNumber);
			break;
		case "4":
			new UserManagement().transactionHistory(accountNumber);
			break;
		}
		if (option != "4") {
			display(pin, accountNumber);
		}
	}

	private void accountTransfer(String pin, long accountNumber) {
		scanner.nextLine();
		// System.out.println("Enter Yor Pin Number : ");
		// String pin = scanner.nextLine();
		// System.out.print("Enetr Account Number : ");
		// long accountNumber = scanner.nextLong();
//		if (userControl.controler(2, accountNumber, pin)) {
		System.out.print("Reciver Account Number : ");
		long reciverAccountNumber = scanner.nextLong();
		if (userControl.controler(1, reciverAccountNumber, pin)) {
			System.out.println(" Enter Amount : ");
			double balance = scanner.nextDouble();
			if (userControl.balanceChecking(accountNumber, balance)) {
				transfer.AmountTransfer(accountNumber, reciverAccountNumber, balance, "AccountTransfer");

			} else {
				System.out.println("Balance Not Sufficient ! ");
			}
		} else {
			System.out.println("User Not Fount ! ");
		}
//		} else {
//			System.out.println("Account Number or Pin Incorrect Please Enter Correct Ac Number and Pin ! ");
//		}
	}

	private void viewBalance(String pin, long accountNumber) {
		if (userControl.controler(2, accountNumber, pin)) {
			userManage.viewBalance(accountNumber);
			return;
		}

	}

}
