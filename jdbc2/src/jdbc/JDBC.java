package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.load and rgister is complted");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
			 //this mthod rturn the implmention object of connection interface
			System.out.println("2.connection established");
			Statement statement = con.createStatement();
			System.out.println("3.platform has created");
			statement.execute("INSERT INTO employee VALUE(4,'Apna college')");
			System.out.println("4.Query executed");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
