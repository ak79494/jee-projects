package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statement1 {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?user=root&password=root");
			Statement statement = con.createStatement();
			statement.execute("Insert into apnacollege VALUES(201, 'ARUN GOSWAMI', 25)");
			System.out.println("Statement executed ");
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM apnacollege");
			System.out.println("Query has executed");
			System.out.println("process of resuult");
			
			if(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
				statement.close();
				System.out.println("statement close");
				con.close();
				System.out.println("connection close");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
