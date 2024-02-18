     
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class BatchProcessing2 {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessingClass?user=root&password=root");
			Statement statement = con.createStatement();
			System.out.println("Statement has created");
			con.setAutoCommit(false);
			
			String SQL = "INSERT INTO batchClass VALUES(90, 'Payal', 19)";
			statement.addBatch(SQL);
			
			String SQL1 = "INSERT INTO batchClass VALUES(91, 'Rashmika mandanna', 28)";
			statement.addBatch(SQL1);
			
			String SQL2 = "INSERT INTO batchClass VALUES(92, 'Alia bhatt', 26)";
			statement.addBatch(SQL2);
			
			int[] batch = statement.executeBatch();
			System.out.println(Arrays.toString(batch));
			con.commit();
			statement.close();
			con.close();
			
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}
	}

}
