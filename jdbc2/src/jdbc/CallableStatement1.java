package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CallableStatement1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor?user=root&password=root");
			CallableStatement statement = con.prepareCall("{call doctor.callableInsert(100,'Shradha',7903508584)}");
			System.out.println("connetion has established");
			statement.execute();
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}

	}

}
