package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class BatchProcessing {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessingClass?user=root&password=root");
		    PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO batchClass VALUE(?,?,?)");
		    con.setAutoCommit(false);
		    
		    preparedStatement.setInt(1,50);
		    preparedStatement.setString(2,"Arun");
		    preparedStatement.setInt(3,24);
		    preparedStatement.addBatch();
		    
		    preparedStatement.setInt(1,51);
		    preparedStatement.setString(2,"Aman");
		    preparedStatement.setInt(3,28);
		    preparedStatement.addBatch();
		    
		    preparedStatement.setInt(1,52);
		    preparedStatement.setString(2,"Shradha");
		    preparedStatement.setInt(3,24);
		    preparedStatement.addBatch();
		    System.out.println("Statement executed");
		    
		    int[] batch =  preparedStatement.executeBatch();
		    System.out.println(Arrays.toString(batch));
		    con.commit();
		    preparedStatement.close();
		    con.close();
		    System.out.println("Record inserted successfully.");
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}
	}

}
