import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class LoginSystemTest {
	public static void main(String[] args) {
		
		System.out.println("Welcome to Dassult Systems...");
		
		SignIn user = new SignIn();
		try {
			user.enterUserDetails();
			user.autharizeUser();
		} catch (SignInNotSucessException e) {
			System.out.println("Problem : "+e);
		}
		
		System.out.println("Thank You...");
	}
}

class SignInNotSucessException extends Exception
{
	SignInNotSucessException(String msg) {
		super(msg);
	}
}
class SignIn
{
	
	
	SignIn() 	{
		//System.out.println("Washing machine is created....but is it ready with electricity....");
	}

	
	String userName;
	String userPassword;
	void enterUserDetails() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Please enter your username:");
			userName=sc.nextLine();
			
			System.out.println("Please enter your password:");
			userPassword=sc.nextLine();
		}
		
	}
	
	
	void autharizeUser() throws SignInNotSucessException
	{
		
		 if(userName.equals("abc") && userPassword.equals("123")) {
						System.out.println("You are sucessfully logined..");
		  }else {
			  SignInNotSucessException washSwitchNotOnEx = new SignInNotSucessException("Please enter a valid credientials.....");
			throw washSwitchNotOnEx;
		  }	
		
		
	}
	
	
}