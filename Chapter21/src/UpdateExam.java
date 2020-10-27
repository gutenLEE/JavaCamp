import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExam {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;		
		Statement stmt = null;
		
		String hakbun, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("update on MEMBER table.....");
			System.out.println("input hakbun that is updated : ");
			hakbun = br.readLine();
			
			System.out.println("input addr that is updated : ");
			addr = br.readLine();
			
			System.out.println("input phone that is updated : ");
			phone = br.readLine(); 
			
			String sql = "update member Set addr = '" + addr;
			sql += "', phone = '" + phone + "' where hakbun = '";
			sql += hakbun + "'";
			
			System.out.println(sql);
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Successful updating");
			
		}
		catch(Exception e) {
			System.out.println("failed to connection" + e.getMessage());
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
