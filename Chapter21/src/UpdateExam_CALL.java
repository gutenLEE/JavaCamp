import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 create or replace procedure call_update(p_hakbun member.hakbun%type, p_addr member.addr%type, p_phone member.phone%type)
is
begin
    update member set addr = p_addr, phone = p_phone where hakbun = p_hakbun;
end;
/
 */
public class UpdateExam_CALL {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		CallableStatement cstmt = null;
		
		String hakbun, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("update data from table...");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
			
			System.out.println("Addr => ");
			addr = br.readLine();
			
			System.out.println("phone => ");
			phone = br.readLine();
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_update(?, ?, ?)}");
			cstmt.setString(1, hakbun);
			cstmt.setString(2, addr);
			cstmt.setString(3, phone);
			cstmt.executeUpdate();
			int res = cstmt.executeUpdate();
			System.out.println(res);
			
			System.out.println("successful connection!");
		}
		catch(Exception e) {
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


















