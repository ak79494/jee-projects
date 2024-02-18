package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class savePoint3 {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testclassSavePoint?user=root&password=root");
			Statement statement = con.createStatement();
			con.setAutoCommit(false);
			statement.executeUpdate("INSERT INTO  testClass VALUE(151, 'India', 20)");
			statement.executeUpdate("INSERT INTO  testClass VALUE(152, 'Russia', 22)");
			System.out.println("Statement has execute,");
			
			Savepoint savepoint = con.setSavepoint("mySavePoint");
			con.rollback(savepoint);
			con.commit();
			statement.close();
			con.close();
			
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}

	}

}
