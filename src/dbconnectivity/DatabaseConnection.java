package dbconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con=null;
	public DatabaseConnection() {
		
	}
	
	public static Connection mydbconnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma_choice","root","root");
//		 System.out.println("DB Connected Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
