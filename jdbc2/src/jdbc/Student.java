package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentClass?user=root&password=root");
			System.out.println("Connection has established");
			Statement statement = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("program has started");
			System.out.println("Enter your rollNumber");
			String rollno = sc.nextLine();
			System.out.println("Enter full name");
			String fullName = sc.nextLine();
			System.out.println("Enter your Subject");
			String subject = sc.nextLine();
			System.out.println("Enter your Gmail");
			String gmail = sc.nextLine();
			if(!gmail.contains("@")) {
				System.out.println("Registor successfull please enter you gmail");
				con.close();
				return;
			}
			System.out.println("Enter your password");
			String password = sc.nextLine();
			if(password.length() <8) {
				System.out.println("password incorret please password must b 8 character");
				con.close();
				return;
			}
			System.out.println("Enter your marks");
			String marks = sc.nextLine();
			 System.out.println("Enter your address");
			 String address = sc.nextLine();
			 
			 System.out.println("Enter your phone");
			 String phone = sc.nextLine();
			 if(phone.length() != 10 || !phone.matches("\\d+")) {
				 System.out.println("phone number incorrect please enter 10 digt phone number");
				 con.close();
				 return;
				 
			 }
			 PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?,?,?,?)");
			 preparedStatement.setString(1,rollno);
			 preparedStatement.setString(2,fullName);
			 preparedStatement.setString(3,subject);
			 preparedStatement.setString(4,gmail);
			 preparedStatement.setString(5,password);
			 preparedStatement.setString(6,marks);
			 preparedStatement.setString(7,address);
			 preparedStatement.setString(8,phone);
			 int rawsInserted = preparedStatement.executeUpdate();
			 if(rawsInserted > 0) {
				 System.out.println("Registration SuccessFul");
			 }else{
				 System.out.println("Registration unSuccessFul please try agin later");
			 }
			 con.close();
			 return;
			 
			 
					
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}

	}

}
