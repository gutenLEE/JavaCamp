import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteExam2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;		
		PreparedStatement pstmt = null;
		
		String hakbun = null;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Delete data of table.....");
			System.out.println("input hakbun that is deleted : ");
			hakbun = br.readLine();
			
			String sql = "Delete From member where trim(hakbun) = ?";
			System.out.println(sql);
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			//conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			pstmt.executeUpdate();
			// int res = stmt.excuteUpdate(sql) => °¹¼ö°¡ ¹ÝÈ¯
			System.out.println("Successful deleting");
			//conn.commit();
		}
		catch(Exception e) {
			System.out.println("failed to connection" + e.getMessage());
		}
		finally {
			try {
				//conn.rollback();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
