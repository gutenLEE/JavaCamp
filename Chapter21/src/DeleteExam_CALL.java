import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DeleteExam_CALL {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		CallableStatement cstmt = null;
		
		String hakbun;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("delete data from table...");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
		
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_delete(?)}");
			cstmt.setString(1, hakbun);
			cstmt.executeUpdate();
			
			int res = cstmt.executeUpdate();
			System.out.println(res);
			
			System.out.println("successful connection!");
			
		}catch(Exception e) {
			System.out.println("failed to connection ! " + e.getMessage());
		}
		
		finally {
			try {
				if(conn != null) conn.close();
				if(cstmt != null) cstmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
	}

}
