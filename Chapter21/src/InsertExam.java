import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExam {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "Insert Into MEMBER(hakbun, name, addr, phone)" + "values";
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
			
			sql += "('" + hakbun + "', '"+ name + "', '"+ addr + "', '"+ phone + "')";
			
			System.out.println(sql);
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			stmt = conn.createStatement();
			
			int res = stmt.executeUpdate(sql);
			if(res == 1)
				System.out.println("Successful inserting");
		}
		catch(Exception e) {
			System.out.println("failed to connection = " + e.getMessage());
		}
		
		finally {
			try {
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try{
				if(stmt != null) stmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if(br != null)br.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}






















