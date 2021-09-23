package summer21jdbc;

import java.sql.*;

public class JdbcExecuteUpdate01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		 
		 Statement st = con.createStatement();
		 
//		 String q1 = "INSERT INTO students VALUES('Faslı Can', 16, null, null)";
//		 
//		 int r1 = st.executeUpdate(q1);
		 
//		 System.out.println(r1 + " row/s inserted");
		 
		 String q2 = "SELECT * FROM students";
		 
		 ResultSet r2 = st.executeQuery(q2);
		 
		 while(r2.next()) {
			 
			 System.out.println(r2.getString(1) + r2.getInt(2));
		 }
		 
		 con.close();
		 st.close();
		 r2.close();
		
	}

}
