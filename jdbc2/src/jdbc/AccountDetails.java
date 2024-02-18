      
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountDetails {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver"); // passing Qualify namabCompany of driver class
			System.out.println("1. load and registered");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeAccount?user=root&password=root");
			System.out.println("2. Connection established");
			
			Statement statement = con.createStatement();
			System.out.println("platform has Created");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("SignUp Process");
			System.out.println("Enter your Account Holder Name");
			String accountHolderName = sc.nextLine();
			System.out.println("Enter your Account Holder Number");
			String accpuntHolderNumber = sc.nextLine();
			System.out.println("Enter your Account Type");
			String accountType = sc.nextLine();
			
			System.out.println("enter your address");
			String address = sc.nextLine();
			
			System.out.println("enter phone number");
			String phone = sc.nextLine();
			if(phone.length() != 10 || !phone.matches("\\d+")) { // valid phone length
				System.out.println("Registration unSuccessFul phone number must be 10 chracter");
				con.close();
				return;
			}
			System.out.println("1) Deposit Money");
			 System.out.println("2) withdraw");
			 System.out.println("3)View Balance");
			 System.out.println("4)exit");
			 String x = sc.nextLine();
			 
			 PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?)");
				preparedStatement.setString(1,accountHolderName);
				preparedStatement.setString(2,accpuntHolderNumber);
				preparedStatement.setString(3,accountType);
				preparedStatement.setString(3,address);
				preparedStatement.setString(5,phone);
				int rawsInserted = preparedStatement.executeUpdate();
				if(rawsInserted > 0) {
					System.out.println("Registration SuccessFul");
				}else{
					System.out.println("Registration unSuccessFul, please try again");
					
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
