package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Statement {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?user=root&password=root");
			java.sql.Statement statement = con.createStatement();
			System.out.println("Statement created");
			statement.execute("INSERT INTO apnacollege VALUES(200, 'ARUN GOSWAMI', 26)");
			System.out.println("STATEMENT EXECUTED");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
