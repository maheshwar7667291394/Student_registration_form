package ConnecttoSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToServer {
   public Connection getConnection(){
	   Connection con=null;
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mahesh";
		try {
			con=DriverManager.getConnection(url,"root","M13a1h8@");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
	   return con;
	   
   }


}
