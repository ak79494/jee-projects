package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/savepointclass?user=root&password=root");
		    con.setAutoCommit(false);
		    PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO classSavePoint VALUE(?,?,?,?)");
		    preparedStatement.setInt(1,51);
		    preparedStatement.setString(2,"Arun");
		    preparedStatement.setInt(3,24);
		    preparedStatement.setString(4,"Male");
		    preparedStatement.executeUpdate();
		    
		    preparedStatement.setInt(1,52);
		    preparedStatement.setString(2,"Shradha");
		    preparedStatement.setInt(3,24);
		    preparedStatement.setString(4,"Female");
		    preparedStatement.executeUpdate();
		    
		    Savepoint savepoint = con.setSavepoint("mySavePoint");
		    System.out.println(" ");
		    
		    Statement statement = con.createStatement();
		    ResultSet resultSet = statement.executeQuery("SElECT * FROM classSavePoint");
		    
		    while(resultSet.next()) {
		    	System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getString(4));
		    	con.rollback(savepoint);
		    }
		    con.commit();
		    preparedStatement.close();
//		    con.close();
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}

	}

}
