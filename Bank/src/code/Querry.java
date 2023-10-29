package code;

public class Querry {
	static String createAccount="INSERT INTO Accounts (AccountHolderName, MobileNo, EmailID, Balance, Password) VALUES(?,?,?,?,?);";
    static String check ="SELECT CASE WHEN (AccountNumber=?) AND Password = ? THEN 1 ELSE 0 END AS 'is_match' FROM accounts;";
    static String checkPassword="SELECT Password FROM accounts WHERE AccountNumber=?;";
    static String creditAmount="UPDATE accounts SET Balance=Balance+ ? WHERE AccountNumber=?;";
    static String withdrawAmount="UPDATE accounts SET Balance=Balance- ? WHERE AccountNumber=?;";
    static String getAccountNumber="SELECT AccountNumber FROM accounts WHERE EmailID=? AND Password=?;";
    static String getBalance="SELECT Balance FROM accounts WHERE AccountNumber=?;";
    static String resetPassword="UPDATE accounts SET Password= ? WHERE AccountNumber= ?;";
}