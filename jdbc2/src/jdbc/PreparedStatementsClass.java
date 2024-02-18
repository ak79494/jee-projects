package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementsClass {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enemy?user=root&password=root");
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO arun VALUES(?,?,?,?)");
			preparedStatement.setInt(1,53);
			preparedStatement.setString(2,"Arun");
			preparedStatement.setInt(3,24);
			preparedStatement.setDouble(4,53.00);
			
			preparedStatement.setInt(1,54);
			preparedStatement.setString(2,"Aman");
			preparedStatement.setInt(3,28);
			preparedStatement.setDouble(4,98.00);
			
			int rawsInserted = preparedStatement.executeUpdate();
			System.out.println(rawsInserted+"raws Inserted");
			
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}
		
		

	}

}
