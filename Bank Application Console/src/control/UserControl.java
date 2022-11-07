package control;

import Management.BankDatabase;
import accounts.Costomer;

public class UserControl {

	public boolean controler(int selection, long accountNumber, String pin) {
		switch (selection) {
		case 1:
			return accountNumberCheck(accountNumber);

		case 2:
			return userIdAndPinCkeck(pin, accountNumber);

		}
		return false;
	}

	private boolean accountNumberCheck(Long accountNumber) {

		if (!BankDatabase.getDatabase().getCostomers().isEmpty()) {
			for (Costomer accounts : BankDatabase.getDatabase().getCostomers()) {
				if (accounts.getAccountNumber() == accountNumber) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean userIdAndPinCkeck(String pin, long accountNumber) {

		if (!BankDatabase.getDatabase().getCostomers().isEmpty()) {
			for (Costomer accounts : BankDatabase.getDatabase().getCostomers()) {
				if (accounts.getAccountNumber() == accountNumber && accounts.getPin().equals(pin)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean balanceChecking(long accountNumber, double amount) {
		for (Costomer accountdata : BankDatabase.getDatabase().getCostomers()) {
			if (accountdata.getAccountNumber() == accountNumber) {
				if (accountdata.getAccountBalance() >= amount)
					return true;
			}

		}
		return false;
	}

}
