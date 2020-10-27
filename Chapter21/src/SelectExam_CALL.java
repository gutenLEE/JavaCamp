import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;
/*
 Create OR REPLACE PROCEDURE call_select(
    v_member_cursor out sys_refcursor
)
is
begin
    open v_member_cursor
    for
    select * from member
    order by hakbun;
end;
/
 */
public class SelectExam_CALL {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_select(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);
			
			System.out.println("hakbun   /   tname   /   taddr   /  tphone  ");
			System.out.println("============================================");
			
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("addr") + "\t");
				System.out.println(rs.getString("phone") + "\n");
			}
			
		}catch(Exception e) {
			System.out.println("failed to connection");
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(cstmt != null) cstmt.close();
				if(conn != null) conn.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
