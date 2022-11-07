package accounts;

public class Costomer {
	private long accountNumber;
	private String name;
	private String accountType;
	private String branchName;
	private String branchId;
	private String dateOfBirth;
	private double accountBalance;
	private String pin;

	public Costomer(long accountNumber,String name,String accountType,String branchName,String branchId,String dateOfBirth,double accountBalance,String pin){
		this.accountNumber=accountNumber;
		this.name=name;
		this.branchName=branchName;
		this.setAccountType(accountType);
		this.branchId=branchId;
		this.dateOfBirth=dateOfBirth;
		this.accountBalance=accountBalance;
		this.pin=pin;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
