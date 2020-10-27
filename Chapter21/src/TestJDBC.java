import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestJDBC {

	public static void main(String[] args) throws Exception{
		
		// driver loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// create Connection object
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
		
		// create Statement object
		Statement stmt = con.createStatement();
		
		// sql
		String sql = "select ename, deptno from emp ";
		
		// start to query
		ResultSet rset = stmt.executeQuery(sql);
		int deptno = 0;
		String name = null;
		
		while(rset.next()) {
			name = rset.getString("ename");
			deptno = rset.getInt("deptno");
			System.out.println(name + "   " + deptno);
		}
	}

}
