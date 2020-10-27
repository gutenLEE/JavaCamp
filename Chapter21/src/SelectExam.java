import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class SelectExam {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		
//		Statement stmt = null;
		PreparedStatement stmt = null;
		
		
		ResultSet rs = null;
		
		String sql = "select * from member order by hakbun";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
//			stmt = conn.createStatement(); // sql ������ ������ �� �ִ� ��ü ����.
			 stmt = conn.prepareStatement(sql);
			
//			rs = stmt.executeQuery(sql);
			 rs = stmt.executeQuery();
			
			System.out.println("hakbun   /    tname     /    taddr    /    tphone");
			System.out.println("-------------------------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("name") + "\t" );
				System.out.print(rs.getString("addr") + "\t");
				System.out.print(rs.getString("phone") + "\n");
			}
		}
		catch(Exception e) {
			System.out.println("failed to connection");
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
