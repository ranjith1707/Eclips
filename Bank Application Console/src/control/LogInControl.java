package control;


public class LogInControl {
	UserControl userControl=new UserControl();

	public boolean loginCheck(String userId,String password) {
		return (userId.equals("adminlogin")&&password.equals("admin@123"));
	}


	public boolean userLogInCheck(long accountNumber, String pin){
		return (userControl.controler(2,accountNumber,pin)&&userControl.controler(1,accountNumber,pin));
	}
}
