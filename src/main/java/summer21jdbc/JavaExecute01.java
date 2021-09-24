package summer21jdbc;

import java.sql.*;

public class JavaExecute01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/*
		 * 	1)In DDL(Data Definition Language : CREATE TABLE, DROP TABLE, ALTER TABLE), we use execute()
		 *  2)execute() returns boolean 
		 * 
		 */
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		Statement st = con.createStatement();
		
//		String q1 = "CREATE TABLE students (id NUMBER(3), name VARCHAR2(50), dob DATE)";
//		
//		boolean isItCreated = st.execute(q1);
//		System.out.println("sonuc : " + isItCreated);
		
//		String q2 = "ALTER TABLE students RENAME COLUMN id TO std_id";
//		boolean olduMU = st.execute(q2);
//		System.out.println("oldu mu ? : " + olduMU);
		
		String q3 = "ALTER TABLE students ADD (std_grade NUMBER(2), std_point NUMBER(3))";
		boolean eklediMi = st.execute(q3);
		System.out.println("ekledi mi? : " + eklediMi);
		
		con.close();
		st.close();
		
		
	}

}
