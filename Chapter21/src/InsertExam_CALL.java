import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
create or replace procedure call_insert(hakbun member.hakbun%type, 
                                        name member.name%type, 
                                        addr member.addr%type,
                                        phone member.phone%type)
is
begin
    insert into member values(hakbun, name, addr, phone);
end;
/
 */
public class InsertExam_CALL {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		CallableStatement cstmt = null;
		String hakbun, name, addr, phone;
		
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Insert data to Member table");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
			
			System.out.println("Name => ");
			name = br.readLine();
			
			System.out.println("Addr => ");
			addr = br.readLine();
			
			System.out.println("Phone => ");
			phone = br.readLine();
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_insert(?, ?, ?, ?)}");
			cstmt.setString(1, hakbun);
			cstmt.setString(2, phone);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
		//	cstmt.executeUpdate();
			int res = cstmt.executeUpdate();
			System.out.println(res);
			
			System.out.println("successful connection!");

		}catch(Exception e) {
			System.out.println("failed to connection!" + e.getMessage());
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













