package summer21jdbc;

import java.sql.*;

public class JdbcCallableStatement01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	
	Statement st = con.createStatement();
 	
		//CREATE a FUNCTION 
	
//	String q1 = "CREATE OR REPLACE FUNCTION additionf (a NUMBER, b NUMBER) "
//			+ "RETURN NUMBER IS "
//			+ "BEGIN return a+b; "
//			+ "END; ";
	
	
//	boolean isRunning = st.execute(q1);
//	System.out.println("Code is running : " + isRunning);
	
//	CallableStatement cst = con.prepareCall("{? = call addf(?,?)}");
	
//	cst.registerOutParameter(1, Types.INTEGER);
//	cst.setInt(2, 32);
//	cst.setInt(3, 54);
	
//	cst.execute();
	
//	System.out.println(cst.getInt(1));
	
		//Create a function which return student name from table when you enter student id
	
//	String q2 = "CREATE OR REPLACE FUNCTION getNameF(id NUMBER)"
//			+ "RETURN VARCHAR2 IS "
//			+ "s_name students.name%TYPE; s_id students.std_id%TYPE;"
//			+ "BEGIN "
//			+ "SELECT name INTO s_name FROM students WHERE std_id = id;"
//			+ "RETURN s_name;"
//			+" END;";
//	
//	st.execute(q2);
	
	CallableStatement cst = con.prepareCall("{? = call getNameF(?)}");
	cst.registerOutParameter(1, Types.VARCHAR);
	cst.setInt(2, 101);

	cst.execute();
	
	System.out.println(cst.getString(1));
	
	
	con.close();
	st.close();
	cst.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}