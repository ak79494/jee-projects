package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginReistration {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver"); // passing Qualify name Company of driver class
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=root");
			Statement statement = con.createStatement();
			System.out.println("platform has Created");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Reistered process started");
			System.out.println("Enter your id");
			String id = sc.nextLine();
			
			System.out.println("Enter your name");
			String name = sc.nextLine();
			
			System.out.println("Enter your Email");
			String email = sc.nextLine();
			if(!email.contains("@")) {
				System.out.println("Reistered Successfull Enter your email");
				con.close();
				return;
			}
			System.out.println("Enter your password");
			String password = sc.nextLine();
			if(password.length() < 8) {
				System.out.println("Reistered UnsuccessFul password must be 8 character");
				con.close();
				return;
			}
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO employees1 VALUES(?,?,?,?)");
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			
			int rawsInserted = preparedStatement.executeUpdate();
			if(rawsInserted > 0) {
				System.out.println("Reistration Successful");
			}else{
				System.out.println("Reistration Unsuccessfull please try again");
			}
			con.close();
			return;
			
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
