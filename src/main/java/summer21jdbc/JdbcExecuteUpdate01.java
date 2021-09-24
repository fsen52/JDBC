package summer21jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		 
		 
		 //Insert multiple records  into a table
		 
		 /*
		  * 1. Step : Create a POJO Class
		  * 			a) Create private variables
		  * 			b) Create constructor without parameters
		  * 			c) Create constructor with all parameters
		  * 			d) Create getters and setters
		  * 			e) Create toString() method
		  * 
		  * 2. Step : Create a list whose elements are the POJO Class objects
		  * 3. Step : By using for-each loop execute INSERT INTO Statement
		  * 
		  */
		 
		 
		 List<MyStudentsPojo> records = new ArrayList<>();
		 
		 records.add(new MyStudentsPojo(18, "Fatih Han"));
		 records.add(new MyStudentsPojo(19, "Osman Can")); 
		 records.add(new MyStudentsPojo(18, "Demir Kan"));
		 
		 int counter = 0;
		 
		 for (MyStudentsPojo w : records) {
			 
			 String q3 = "INSERT INTO students VALUES(" + w.getStd_age() + ",'" +  w.getStd_name() + "')";
			//System.out.println(q3);
			 
			  counter = counter + st.executeUpdate(q3);
		 }
		 
		 System.out.println(counter + " rows inserted");
		 
		 
		 
		 
		 con.close();
		 st.close();
		 r2.close();
		
	}

}
