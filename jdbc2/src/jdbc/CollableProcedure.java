package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CollableProcedure {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enemy?user=root&password=root");
			CallableStatement callableStatement = con.prepareCall("{call enemy.fetch(?,?,?,?)}");
			callableStatement.registerOutParameter(1,Types.INTEGER);
			callableStatement.registerOutParameter(2,Types.VARCHAR);
			callableStatement.registerOutParameter(3,Types.INTEGER);
			callableStatement.registerOutParameter(4,Types.DOUBLE);
		    ResultSet resultSet = callableStatement.executeQuery();	
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getDouble(4));
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

}
