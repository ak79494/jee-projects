package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Resultset2 {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/callable?user=root&password=root");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM callablestate");
			if(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
				System.out.println("execute query");   
			}
			statement.close();
			System.out.println("statment close");
			con.close();
			System.out.println("connection close");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

 }
    