 package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor?user=root&password=root");
			CallableStatement callableStatement = con.prepareCall("{call doctor.stored(?,?,?)}");
			callableStatement.registerOutParameter(1,Types.INTEGER);
			callableStatement.registerOutParameter(2,Types.VARCHAR);
			callableStatement.registerOutParameter(3,Types.VARCHAR);
			ResultSet resultSet = callableStatement.executeQuery("SELECT * FROM patient");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getLong(3));
			}
			
			
		}catch(ClassNotFoundException | SQLException  e) {
			 e.printStackTrace();
		}

	}

}
