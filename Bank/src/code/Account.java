package code;

class Account {
//	private int AccountNumber=23457;
	private String Password;
	private String AccountHolderName;
	private float Balance;
	private String EmailID;
	private long MobileNo;
	Account(String AccountHolderName,String Password,float Balance,
			String EmailID,long MobileNo){
		this.Password=Password;
		this.Balance=Balance;
		this.AccountHolderName=AccountHolderName;
		this.EmailID=EmailID;
		this.MobileNo=MobileNo;
//		this.AccountNumber=AccountNumber+1;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public float getBalance() {
		return Balance;
	}
	public String getPassword() {
		return Password;
	}
	public String getEmailID() {
		return EmailID;
	}
	public long getMobileNo() {
		return MobileNo;
	}
//	public int getAccountNumber() {
//		return AccountNumber;
//	}
}
