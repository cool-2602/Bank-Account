package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection connect() {
		String url="jdbc:mysql://localhost:3306/bankaccounts";
		String UserName="root";
		String Password="Kulvant@26";
		Connection con = null;
		try {			
			con = DriverManager.getConnection(url,UserName,Password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
}
