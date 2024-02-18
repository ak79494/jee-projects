package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class PracticeClass {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?user=root&password=root");
			Statement statement = con.createStatement();
			System.out.println("platform has created");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("SignUp process start");
			System.out.println("Enter your id");
			String id = sc.nextLine();
			System.out.println("Enter your name");
			String name = sc.nextLine();
			System.out.println("Enter your email");
			String email = sc.nextLine();
			if(!email.contains("@")) {
				System.out.println("Registration SuccessFul please enter your email");
				con.close();
				return;
				
			}
			System.out.println("Enter your password");
			String password = sc.nextLine();
			if(password.length() < 8) {
				System.out.println("Registration SuccessFul pasword at least 8 character long");
				con.close();
				return;
				
			}
			System.out.println("Enter your phoneNumber");
			String phone = sc.nextLine();
			if(phone.length() != 10 || !phone.matches("\\d+")) {
				con.close();
				return;	
			}
			System.out.println("Enter your Designation");
			String designation = sc.nextLine();
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO practiceClass VALUES(?,?,?,?,?,?)");
			preparedStatement.setString(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,email);
			preparedStatement.setString(4,password);
			preparedStatement.setString(5,phone);
			preparedStatement.setString(6,designation);
			
			int rawInserted = preparedStatement.executeUpdate();
			if(rawInserted > 0) {
				System.out.println("Registration SuccessFul");
		    }else{
		    	System.out.println("Registration unSuccessFul");
		    }
			con.close();
			return;	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
