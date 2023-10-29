package code;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Bank");

        Scanner scan = new Scanner(System.in);

        System.out.println("1. Create Account.");
        System.out.println("2. Deposit.");
        System.out.println("3. Withdrawal.");
        System.out.println("4. Balance Inquiry.");
        System.out.println("5. Reset Account Password.");

        boolean bool=true;
        while(bool) {
        	System.out.println("Enter your Choice.");
        	String Choice = scan.nextLine();
	        switch (Choice) {
	            case "1":
	                System.out.println("You selected Create Account.");
	    			System.out.println("Enter your name.");
	    			scan.nextLine();
	    			String AccountHolderName = scan.nextLine();
	//    			System.out.println(AccountHolderName);
	    			
	    			System.out.println("Enter your Moblie No.");
	    			long MobileNo = scan.nextLong();
	    			scan.nextLine();
	//    			System.out.println(MobileNo);
	  			
	    			System.out.println("Enter your Email Id");
	    			String EmailID = scan.nextLine();
	//    			System.out.println(EmailID);
	    			
	    			System.out.println("Enter Balance You want to add.");
	    			float Balance = scan.nextFloat();
	    			scan.nextLine();
	//    			System.out.println(Balance);
	    			
	    			String Password = Security.setEncryptPassword(Security.getEnteredPassword());
	    			
	    			Account account = new Account(AccountHolderName,Password,Balance,
					EmailID,MobileNo);
	    			Execution.CreateAccount(account);
	    			System.out.println("Account is Created.");
	    			System.out.println("Your Account Number is - "
	    			+Execution.getAccountNumber(account.getEmailID(),account.getPassword()));
	    			
	                break;
	                
	                
	            case "2":
	                System.out.println("You selected Deposit.");
	                System.out.println("Enter Account Number.");
	                int AccountNumber = scan.nextInt();
	                System.out.println("Enter your Password.");
	                scan.nextLine();
	                Password =scan.nextLine();
	                boolean Match=Execution.isVaildAccount(AccountNumber,Password);
	//                System.out.println(Match);
	                if(Match) {
	                	System.out.println("Enter amount which you want to add");
	                	float Amount=scan.nextFloat();
	                	int count =Execution.DepositAmount(AccountNumber,Amount);
	                	if(count>0) {
	                		System.out.println("your amount is deposited");
	                		System.out.println("your updated balance is - "+Execution.getBalance(AccountNumber));
	                	}else {
	                		System.out.println("Server Issues");
	                	}
	                }else {
	                	System.out.println("Invalid Credintial");
	                }
	                break;
	                
	                
	            case "3":
	                System.out.println("You selected Withdrawal.");
	                System.out.println("Enter Account Number.");
	                AccountNumber = scan.nextInt();
	                System.out.println("Enter your Password.");
	                scan.nextLine();
	                Password =scan.nextLine();
	                Match=Execution.isVaildAccount(AccountNumber,Password);
	//                System.out.println(Match);
	                if(Match) {
	                	System.out.println("Enter amount which you want to Withdrawal ");
	                	float Amount=scan.nextFloat();
	                	int count =Execution.WithdrawalAmount(AccountNumber,Amount);
	                	if(count>0) {
	                		System.out.println("your amount is Debited ");
	                		System.out.println("your updated balance is - "+Execution.getBalance(AccountNumber));
	                	}else {
	                		System.out.println("Insuficient Amount");
	                	}
	                }else {
	                	System.out.println("Invalid Credintial");
	                }
	                break;
	                
	                
	            case "4":
	                System.out.println("You selected Balance Inquiry.");
	                System.out.println("Enter Account Number.");
	                AccountNumber = scan.nextInt();
	                System.out.println("Enter your Password.");
	                scan.nextLine();
	                Password =scan.nextLine();
	                Match=Execution.isVaildAccount(AccountNumber,Password);
	                if(Match) {
	                	System.out.println("Your Balance is - "+Execution.getBalance(AccountNumber));
	                }else {
	                	System.out.println("Invalid Credintial");
	                }
	                break;
	                
	            case "5":
	            	System.out.println("You selected Reset Account Password.");
	            	System.out.println("Enter Account Number.");
	                AccountNumber = scan.nextInt();
	                System.out.println("Enter your Password.");
	                scan.nextLine();
	                Password =scan.nextLine();
	                Match=Execution.isVaildAccount(AccountNumber,Password);
	                if(Match) {
	                	int count=Execution.ResetAccountPassword(AccountNumber);
	                	if(count>0) {
	                		System.out.println("Your Password is Reset. ");
	                	}else {
	                		System.out.println("Password isn't Reset");
	                	}
	                }else {
	                	System.out.println("Invalid Credintial");
	                }
	                break;
	                
	            default:
	                System.out.println("Invalid Choice.");
	                break;
	        }
	        boolean bool1=true;
	        while(bool1) {
	        	System.out.println("Enter 'yes' for repeat And 'no' for close");
	        	String check= scan.nextLine().toLowerCase();
	        	if(check.equals("yes")) {
	        		bool=true;
	        		bool1=false;
	        	}else if(check.equals("no")) {
	        		bool=false;
	        		bool1=false;
	        	}else {
	        		System.out.println("Enter valid word (yes or no) ");
	        	}
	        }
        }
        System.out.println("System is close");
        scan.close();
	}
}
class abc{
	public static void main(String[] args) {
		
	}
}
