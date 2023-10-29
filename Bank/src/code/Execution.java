package code;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Execution {

	public static void CreateAccount(Account account) {
		Connection con = DBConnection.connect();
		String querry = Querry.createAccount;
		try {
			PreparedStatement pst = con.prepareStatement(querry);
//			pst.setInt(1, account.getAccountNumber());
			pst.setString(1, account.getAccountHolderName());
			pst.setLong(2, account.getMobileNo());
			pst.setString(3, account.getEmailID());
			pst.setFloat(4, account.getBalance());
			pst.setString(5, account.getPassword());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isVaildAccount(int AccountNumber,String Password) {
		Connection con = DBConnection.connect();
		String querry = Querry.checkPassword;
		ResultSet rs = null;
		try {
			PreparedStatement pst = con.prepareStatement(querry);
			pst.setInt(1, AccountNumber);
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				if(Security.getDecryptPassword(rs.getString(1)).equals(Password)) {
					return true;
				}else {
					return false;
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static int DepositAmount(int accountNumber,float Amount) {
		Connection con = DBConnection.connect();
		String querry = Querry.creditAmount;
		int count=0;
		try {
			PreparedStatement pst = con.prepareStatement(querry);
			pst.setFloat(1, Amount);
			pst.setInt(2, accountNumber);
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public static float getBalance(int AccountNumber) {
		Connection con = DBConnection.connect();
		String querry = Querry.getBalance;
		ResultSet rs = null;
		float amount=0;
		try {
			PreparedStatement pst = con.prepareStatement(querry);
			pst.setInt(1, AccountNumber);
			rs=pst.executeQuery();
			while(rs.next()) {
				amount=rs.getFloat(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return amount;
	}
	
	public static int getAccountNumber(String EmailID,String Password) {
		Connection con = DBConnection.connect();
		String querry = Querry.getAccountNumber;
		ResultSet rs = null;
		int AccountNumber=0;
		try {
			PreparedStatement pst = con.prepareStatement(querry);
			pst.setString(1, EmailID);
			pst.setString(2, Password);
			rs=pst.executeQuery();
			if (rs!=null) {				
				while(rs.next()) {
					AccountNumber=rs.getInt(1);
				}
			}else {
				return -1;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return AccountNumber;
	}

	public static int WithdrawalAmount(int AccountNumber, float Amount) {
		Connection con = DBConnection.connect();
		String querry = Querry.withdrawAmount;
		int count=0;
		float newAmount=Execution.getBalance(AccountNumber);
		try {
			if(Amount>newAmount) {
				return -1;
			}
			PreparedStatement pst = con.prepareStatement(querry);
			pst.setFloat(1, Amount);
			pst.setInt(2, AccountNumber);
			count = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public static int ResetAccountPassword(int AccountNumber) {
		Connection con = DBConnection.connect();
		String querry = Querry.resetPassword;
		int count=0;
		String newPassword = Security.getResetPassword();
		try {
			PreparedStatement pst = con.prepareStatement(querry);
			pst.setString(1, newPassword);
			pst.setInt(2, AccountNumber);
			count=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
