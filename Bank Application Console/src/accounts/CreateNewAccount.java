package accounts;

import java.util.Scanner;
import java.util.regex.Pattern;

import Management.BankDatabase;

import java.util.regex.Matcher;
import accounts.BankDetails;
import control.DatabaseController;

public class CreateNewAccount {
	private BankDetails details = new BankDetails();
	private Scanner scanner = new Scanner(System.in);
	private DatabaseController dataInsertion = new DatabaseController();

	private void dataCollection() {
		long accountNumber = details.accountNumber();
		System.out.println("Enter Name : ");
		String name = scanner.nextLine();
		Pattern nameCkecking = Pattern.compile("^[A-Z]");
		Matcher matching = nameCkecking.matcher(name);
		while (!matching.find()) {
			System.out.println("Name Must Be Start With Upper Case  ! \n Enter Name : ");
			name = scanner.nextLine();
			matching = nameCkecking.matcher(name);
		}
		System.out.print("Enter Mobile Number : ");
		String mobileNumber = scanner.nextLine();
		Pattern numberCkecking = Pattern.compile("^[6-9][0-9]{9}");
		Matcher numberMatch = numberCkecking.matcher(mobileNumber);
		while (!numberMatch.find()) {
			System.out.println("Invalid Mobile Number ! \n Enter Mobile Number : ");
			mobileNumber = scanner.nextLine();
			numberMatch = numberCkecking.matcher(mobileNumber);
		}
		System.out.println("Enter Date Of Birth ( 'Format':  YYYY - MM - DD :   ");

		String dateOfBirth = scanner.nextLine();
		System.out.println("select Branch Name : ");
		String branchName = details.branchName();
		String branchId = details.branchId(branchName);
		System.out.println("Select Account  \n 1 > Savings Account\n 2 > Salary Account ");
		int accountSelection = scanner.nextInt();
		String accountType;
		if (accountSelection == 1) {
			accountType = "Savings";
		} else {
			accountType = "Salary Account";
		}
		double accountBalance = details.accountBalance(accountType);
		scanner.nextLine();
		System.out.print("Create Pin Number");
		String pin = scanner.nextLine();
		BankDatabase.getDatabase().setCostomers(
				new Costomer(accountNumber, name, accountType, branchName, branchId, dateOfBirth, accountBalance, pin));
		dataInsertion.dataInsert(
				"insert into costomerDetails(AccountNumber,Name,accountType,branchName,branchid,DateOfBirth)values("
						+ accountNumber + ",'" + name + "','" + accountType + "','" + branchName + "','" + branchId
						+ "','" + dateOfBirth + "')");
		dataInsertion.dataInsert("insert into accountDetails(accountNumber,accountBalance,pinNo)values(" + accountNumber
				+ ",+" + accountBalance + ",'" + pin + "')");
		System.out.println("_________________________________________________________________");
	}

	public void access() {
		System.out.println("   >  Welcome to HDFC  Bank   < ");
		dataCollection();

	}
}
