package summer21jdbc;

import java.sql.*;

public class JdbcPreparedStatement02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	
	Statement st = con.createStatement();
	
	
	//Dynamic UPDATE SET
	
	
	
	String q1 = "UPDATE students SET std_grade = ? WHERE std_id = ?";
	
	PreparedStatement pst = con.prepareStatement(q1);
	
	pst.setInt(1,5); //1 is first question mark in the query
	pst.setInt(2,101); //2 is second question mark in the query
	
	pst.executeUpdate();
	
	
	
	
	
	pst.close();
	st.close();
	con.close();
	
	
	}
}