package dashboard;

import control.DatabaseController;
import java.util.Scanner;

import Management.AccountManagement;
import Management.BankDatabase;
import control.LogInControl;

public class LogInPage {
	LogInControl control = new LogInControl();
	AccountManagement accountmanager = new AccountManagement();
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		LogInPage loginpage = new LogInPage();
		loginpage.view();
	}

	void view() {
		DatabaseController transfer = new DatabaseController();
		transfer.dataTransfer();
		BankDatabase.getDatabase().accountNumberBigin();
		System.out.println(" 1 > Admin(Bank) Login\n 2 > User Login\n 3 > Exit \n  ");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			bankLogin();
			break;
		case "2":
			userLogin();
			break;
		case "3":
			break;
		default:
			view();
		}
		if ((option.equals("1") || option.equals("2"))) {
			view();
		}
//		else {
//			System.out.println("")
//		}

	}

	void userLogin() {
		System.out.print("Enter Your Account Number : ");

		try {
			long accountNumber = scanner.nextLong();

			System.out.print("Enter Pin : ");
			String pin = scanner.next();
			if (control.userLogInCheck(accountNumber, pin)) {
				accountmanager.display(pin, accountNumber);
			} else {
				System.out.println("User Id Or password Incorrect ! ");
			}
		} catch (Exception e) {
			System.out.println("Eneter Numbers Only ");
			System.out.println("----------------------------");

		}
	}

	void bankLogin() {
		LogInControl control = new LogInControl();
		System.out.print("Enetr User ID  :");
		String userId = scanner.nextLine();
		System.out.print("Enter Pin Number : ");
		String password = scanner.nextLine();
		if (control.loginCheck(userId, password)) {
			accountmanager.display();
		} else {
			System.out.println("User Id Incorrect ! Enter Correct User Id : ");
			bankLogin();
		}
	}
}
