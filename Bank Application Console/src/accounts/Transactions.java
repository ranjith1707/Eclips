package accounts;

public class Transactions {
	private long accountNumber;
	private String date;
	private String time;
	private long reciverAccountNumber;
	private double amount;
	private String status;

	public Transactions(long accountNumber, String date, String time, long reciverAccountNumber, double amount,
			String status) {
		this.accountNumber = accountNumber;
		this.date = date;
		this.time = time;
		this.reciverAccountNumber = reciverAccountNumber;
		this.amount = amount;
		this.status = status;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getReciverAccountNumber() {
		return reciverAccountNumber;
	}

	public void setReciverAccountNumber(long reciverAccountNumber) {
		this.reciverAccountNumber = reciverAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
