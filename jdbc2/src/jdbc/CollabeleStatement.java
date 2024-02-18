package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CollabeleStatement {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor?user=root&password=root");
			CallableStatement statement = con.prepareCall("{call doctor.insert(101, 'Aman',7903508584)}");
			System.out.println("established connection");
			statement.execute();
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException  e) { 
			 e.printStackTrace();
			 
		}
		

	}

}
