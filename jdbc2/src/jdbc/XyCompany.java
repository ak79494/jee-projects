package jdbc;           
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
public class XyCompany {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver"); // // passing qualify name of driver class
			System.out.println("1 load and rgistered");
			Properties pr = new Properties();
			FileReader reader = new FileReader("resource\\yz.properties");
			pr.load(reader);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments",pr);
			System.out.println("2 connection established");
			Statement statement = con.createStatement();
			System.out.println("platform has creatd");
			statement.execute("INSERT INTO aman2 VALUE(1,'Shekhar',12345678,'Jharkhand dhanbad', 7903508584)");
			statement.execute("INSERT INTO aman2 VALUE(2,'Aman',123456789,'Jharkhand dhanbad', 7903508585)");
			statement.execute("INSERT INTO aman2 VALUE(3,'Arun',123456788,'Jharkhand dhanbad', 790350856)");
			statement.execute("INSERT INTO aman2 VALUE(4,'payal',12345677,'Jharkhand dhanbad', 7903508587)");
			statement.execute("INSERT INTO aman2 VALUE(5,'mukesh',12345678,'Jharkhand dhanbad', 7903508588)");
			System.out.println("query has executed");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter String value");
			String x = sc.nextLine();
				
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
