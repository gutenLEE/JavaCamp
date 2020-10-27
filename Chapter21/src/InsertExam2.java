import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// PreparedStatement 사용 버전

public class InsertExam2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "Insert Into MEMBER(hakbun, name, addr, phone) " + "values(?,?,?,?)";
		String hakbun, name, addr, phone;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 추가하기");
			System.out.println("input 학번 :  ");
			hakbun = br.readLine();
			
			System.out.println("input your name : ");
			name = br.readLine();
			
			System.out.println("input your addr : ");
			addr = br.readLine();
			
			System.out.println("input your phone Number : ");
			phone = br.readLine();
			
			System.out.println(sql);
			
			// driver to load
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			
			System.out.println("succsessful connection");
		}
		catch(Exception e) {
			System.out.println("failed to connection = " + e.getMessage());
		}
		
		finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}






















