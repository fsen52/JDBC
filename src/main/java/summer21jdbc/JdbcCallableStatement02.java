package summer21jdbc;

import java.sql.*;

public class JdbcCallableStatement02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	
	Statement st = con.createStatement();
	
	
	//1. Example : Create a procedure to find the minimum of 2 numbers
	
//	String q1 = " CREATE OR REPLACE PROCEDURE findMin(a IN NUMBER, b IN NUMBER, result OUT NUMBER) IS "
//			+ "BEGIN "
//			+ "IF a<b THEN result := a; "
//			+ "ELSE result:=b; "
//			+ "END IF; "
//			+ "END; ";
//	
//	st.execute(q1);
	
	// How to call procedure
	
//	CallableStatement cst = con.prepareCall("{call findMin(?, ?, ?)}");
//	
//	cst.setInt(1, 5);
//	cst.setInt(2, 7);
//	cst.registerOutParameter(3, Types.INTEGER);
//	
//	cst.execute();
//	
//	System.out.println(cst.getInt(3));
	
	
	//2. Example : Create a procedure to get the name from students table when you enter student id
	
	
//	String q2 = " CREATE OR REPLACE PROCEDURE getName(id IN NUMBER, result OUT VARCHAR2) IS "
//			+ "BEGIN "
//			+ "SELECT name INTO result FROM students WHERE std_id = id;"
//			+ "END;";
//	
//	st.execute(q2);
	
//	CallableStatement cst1 = con.prepareCall("{call getName(?, ?)}");
//	
//	cst1.setInt(1, 101);
//	
//	cst1.registerOutParameter(2, Types.VARCHAR);
//	
//	cst1.execute();
//	
//	System.out.println(cst1.getString(2));
	
	//3.Example : Create a procedure to increase the id by 1 for the student selected by name.
	
	String q3 = "CREATE OR REPLACE PROCEDURE incId(value IN VARCHAR2, result OUT NUMBER) IS "
			+ "BEGIN "
			+ "UPDATE students SET std_id = std_id + 1 WHERE name = value;"
			+ "SELECT std_id INTO result FROM students WHERE  name = value; "
			+ "END;";
	
	st.execute(q3);
	
	CallableStatement cst2 = con.prepareCall("{call incId(?, ?)}");
	
	cst2.setString(1, "Ali Can");
	
	cst2.registerOutParameter(2, Types.INTEGER);
	
	cst2.execute();
	
	System.out.println(cst2.getInt(2));

	
	
	
	
	con.close();
	st.close();
	//cst.close();
	cst2.close();
	
	
	
	}
}