package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class advance {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("1. load and rgisteed completed");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/college?user=root&password=root");
			System.out.println("2. connection  estabished");
			Statement statement = con.createStatement();
			System.out.println("platform has created");
			statement.execute("INSERT INTO apnacollege VALUE(1,'Shradha',24)");
			/*statement.execute("INSERT INTO apnacollege VALUE(2,'Arun',25)");
			statement.execute("INSERT INTO apnacollege VALUE(3,'Aman',26)");
			statement.execute("INSERT INTO apnacollege VALUE(4,'Rashmika',28)");*/
			System.out.println("4.Query executed");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException  e) { 
			 e.printStackTrace();
			 
		}
		
		
	}
}
