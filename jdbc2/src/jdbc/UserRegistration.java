package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserRegistration {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // passing Qualify namabCompany of driver class
			System.out.println("1. load and registered");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
			System.out.println("2. Connection established");
			
			Statement statement = con.createStatement();
			System.out.println("platform has Created");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("SignUp Process");
			System.out.println("Enter your fullName");
			String fullName = sc.nextLine();
			System.out.println("Enter your email");
			String email = sc.nextLine();
			if(!email.contains("@")) { // valid email format
				System.out.println("Registration successFul please enter your email");
				con.close();
				return;
			}
			System.out.println("enter your password");
			String password = sc.nextLine();
			if(password.length() < 8) { // valid password length
				System.out.println("Registration unSuccessFul password must b atleast 8 caharcater long ");
				con.close();
				return;
			}
			System.out.println("enter your address");
			String address = sc.nextLine();
			System.out.println("enter phone number");
			String phone = sc.nextLine();
			if(phone.length() != 10 || !phone.matches("\\d+")) { // valid phone length
				System.out.println("Registration unSuccessFul phone number must be 10 chracter");
				con.close();
				return;
			}
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?)");
			preparedStatement.setString(1,fullName);
			preparedStatement.setString(2,email);
			preparedStatement.setString(3,password);
			preparedStatement.setString(4,address);
			preparedStatement.setString(5,phone);
			
			int rawsInserted = preparedStatement.executeUpdate();
			if(rawsInserted > 0) {
				System.out.println("Registration SuccessFul");
			}else{
				System.out.println("Registration unSuccessFul, please try again");
				
			}
			con.close();
			return;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
