package Management;

import java.util.*;
import accounts.*;
import control.DatabaseController;

public class BankDatabase {
	static BankDatabase bankDB;
	private List<Costomer> costomers;
	private List<Transactions> transactionHistory;
	private long accountNumber;

	private BankDatabase() {
		costomers = new ArrayList<Costomer>();
		transactionHistory = new ArrayList<Transactions>();

	}

	public static BankDatabase getDatabase() {
		if (bankDB == null) {
			bankDB = new BankDatabase();
		}
		return bankDB;
	}

	public List<Transactions> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<Transactions> history) {
		this.transactionHistory.addAll(history);
	}

	public void setTransactionHistory(Transactions history) {
		this.transactionHistory.add(history);
	}

	public List<Costomer> getCostomers() {
		return costomers;
	}

	public void setCostomers(List<Costomer> costomersDetails) {
		this.costomers.addAll(costomersDetails);
	}

	public void setCostomers(Costomer account) {
		costomers.add(account);
	}

	public long getAccountNumber() {
		setAccountNumber();
		return accountNumber;
	}

	public void accountNumberBigin() {
		DatabaseController numbersetting = new DatabaseController();
		this.accountNumber = numbersetting.getAccountNumber();
	}

	private void setAccountNumber() {
		this.accountNumber += 1;
	}
}