package summer21jdbc;

//1.Step
import java.sql.*;

public class JdbcExecuteQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//2.Step
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.Step
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr" , "hr");
		
		//4.Step
		
		Statement st = con.createStatement();
		
		//5.Step
		
		String q1 = "SELECT * FROM students";
		ResultSet r1 = st.executeQuery(q1);
		
		//6.Step
		
		while(r1.next()) {
			
			System.out.println(r1.getInt(1) + " - " + r1.getString(2));
		}
		
		String q2 =  "SELECT * "
				+ "FROM students "
				+ "WHERE std_age < 102";
		
		ResultSet r2 = st.executeQuery(q2);
		
		while(r2.next()) {
			
			System.out.println(r2.getString("std_name"));
		}
		
		
		//7.Step
		
		con.close();
		st.close();
		r1.close();
	
	
	}

}
