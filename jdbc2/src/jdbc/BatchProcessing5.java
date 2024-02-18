package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchProcessing5 {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessingClass?user=root&password=root");
			Statement statement = con.createStatement();
			System.out.println("Statment created");
			
			con.setAutoCommit(false);
			String SQL = "INSERT INTO batchClass VALUES (200, 'Raveena', 34)";
			statement.addBatch(SQL);
			
			String SQL1 = "INSERT INTO batchClass VALUES (200, 'Rasa', 24)";
			statement.addBatch(SQL1);
			int[] batch =  statement.executeBatch();
			System.out.println(Arrays.toString(batch));
			con.commit();
			statement.close();
			con.close();
			
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}
	}
}
