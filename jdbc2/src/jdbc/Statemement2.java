package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Statemement2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/college?user=root&password=root");
		    Statement statement = con.createStatement();
		    statement.execute("INSERT INTO apnacollege VALUES(251,'Shruti',19)");
		    System.out.println("Statement Executed");
		    
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM apnacollege");
		    if(resultSet.next()) {
		    	System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
		    	statement.close();
		    	System.out.println("Statement closed");
		    	con.close();
		    	System.out.println("connection closed");
		    	
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
