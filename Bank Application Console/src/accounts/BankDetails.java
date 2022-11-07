package accounts;
import java.util.*;
import Management.BankDatabase;

public class BankDetails {

	String[] brancheNames= {" Surandai", "Tenkasi","Tirunelveli", "Madurai", "Thoothukudi", "Chennai"};
	String[] branchId= {"62","76","72","50","71","10"};

	Scanner scanner=new Scanner(System.in);
	protected double accountBalance(String accountType) {
		if(accountType.equals("Savings")) {
			
			return 1000.00;
			
		}
		
		return 00.00;
	}

	protected long accountNumber() {

		return BankDatabase.getDatabase().getAccountNumber();
	}

	protected String branchName() {
		int roolNumber=1;
		for(String branch:brancheNames) {
			System.out.println(" "+roolNumber+" > " +branch);
		}
		int option=scanner.nextInt();
		if(option >0&&option<=brancheNames.length) {
			return brancheNames[option-1];
		}
		return branchName();
	}



	protected String branchId(String branchName) {
		return (branchId[branchName.indexOf(branchName)]);

	}
}
