import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateExam2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;		
		PreparedStatement pstmt = null;
		
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
			
			String sql = "update member Set addr = ?, phone = ? where trim(hakbun) = ?";
			
			System.out.println(sql);
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, phone);
			pstmt.setString(3, hakbun);
			int res = pstmt.executeUpdate();
			System.out.println("res : " + res);
			System.out.println("Successful updating");
			
		}
		catch(Exception e) {
			System.out.println("failed to connection" + e.getMessage());
		}
		finally {
			try {
				// 사용순서와 반대로 close함
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
