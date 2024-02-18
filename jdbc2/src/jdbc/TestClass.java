package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TestClass {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testclassSavePoint?user=root&password=root");
		    Statement statement = con.createStatement();
		    con.setAutoCommit(false);
		    statement.executeUpdate("INSERT INTO testClass VALUES(1,'Arun',24)");
		    statement.executeUpdate("INSERT INTO testClass VALUES(2,'Aman',25)");
		    System.out.println("statement has execute");
		    Savepoint savepoint = con.setSavepoint("mySavePoint");
		    
		    con.rollback(savepoint);
		    con.commit();
		    con.close();
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}
	}
}
