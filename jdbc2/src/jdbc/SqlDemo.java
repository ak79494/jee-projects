package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("1. load and registered completed");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlClass?user=root&password=root");
		    System.out.println("Connection established");
		    Statement statement = con.createStatement();
		    System.out.println("3 Platform created");
		    System.out.println("do you want to registered y/N");
		    String yn = sc.nextLine();
		    int id=100;
		    while(yn.equalsIgnoreCase("y")) {
		         System.out.println("Enter your name");
		         String name= sc.nextLine();
		         System.out.println("Enter your password");
		         String password = sc.nextLine();
		         System.out.println("Enter your address");
		         String address = sc.nextLine();
		         System.out.println("Enter your number");
		         long number = sc.nextLong();
		         statement.execute("INSERT INTO student1("+id+"','"+name+"','"+password+"','"+address+"',"+number+")");
		         System.out.println("registered successfully");
		         id++;
		         
		        	
		   // statement.execute("INSERT INTO student1 VALUE(101, 'Shekhar',12345678,'jharkhand dhanbad',7903508584)");
		    System.out.println("Query has executed");
		    }
		     System.out.println("phone number no exixt");
		        	 System.out.println("do you want to registered y/N");
		             sc.nextLine();
		             yn = sc.nextLine();
		    
		    statement.close();
		    System.out.println("Statement has closed");
		    con.close();
		    
		    
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			 e.printStackTrace();
		}
		
	}

}
