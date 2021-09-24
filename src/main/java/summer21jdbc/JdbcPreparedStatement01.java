package summer21jdbc;

import java.sql.*;

public class JdbcPreparedStatement01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	
	Statement st = con.createStatement();
	//dynamic insertion operation
	
	
	String q1 = "INSERT INTO students VALUES(?, ?, ?, ?, ?)";
	
	PreparedStatement pst = con.prepareStatement(q1);
	
//	
//	pst.setInt(1, 101);
//	pst.setString(2, "Ali Can");
//	pst.setString(3, "11-Aug-2005");
//	pst.setInt(4, 3);
//	pst.setInt(5, 100);
//	
//	pst.executeUpdate();

	
//	pst.setInt(1, 102);
//	pst.setString(2, "Veli Han");
//	pst.setString(3, "11-Aug-2009");
//	pst.setInt(4, 3);
//	pst.setInt(5, 90);
//	
//	pst.executeUpdate();
	
	
	
	
	String q2 = "SELECT * FROM students";
	ResultSet r2 = st.executeQuery(q2);
	
	while(r2.next()) {
		
		System.out.println(r2.getString(1) + " - " + r2.getString(2) + " - " + r2.getString(3) + " - " + r2.getString(4) + " - " + r2.getString(5) );
	
	}
	
	
	
	
	
	
	
	
	
	con.clearWarnings();
	st.close();
	pst.close();
	r2.close();
	
	
	
	
	
	}

}
