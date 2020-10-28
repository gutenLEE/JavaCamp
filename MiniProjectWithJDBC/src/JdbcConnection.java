import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JdbcConnection {
	
	JTable table;
	JTextField textField [];
	
	JdbcConnection(JTable table, JTextField textField []){
		
		this.table = table;
		this.textField = textField;
		
	}
	
	void insert() {
		
		String arr[] = new String[textField.length];
		
		for(int i = 0; i < textField.length; i++) {
			arr[i] = textField[i].getText();
			System.out.println(arr[i]); // 객체가 참조는 잘 하고 있군...
		}
		
		// 아래부터 jdbc insert하기
		Connection con = null;
		
	 	con = connectDB();
	 	PreparedStatement pstmt = null;
	 	String sql = "insert into userInfo values(?, ?)";
		
	 	try{
	 		pstmt = con.prepareStatement(sql);
	 		pstmt.setString(1, arr[0]);
	 		pstmt.setString(2, arr[1]);
	 		
	 		int res = pstmt.executeUpdate();
	 		
	 		if(res == 1)
	 			System.out.println("jdbc insert successs!");
	 		else
	 			System.out.println("This is inesrt() : failed to connection");
	 	}
	 	catch(Exception e){
	 		popUp("데이터베이스 오류입니다." + e.getMessage());
	 		System.out.println(e.getMessage());
	 	}
	 	finally{
	 		try{
	 			if(pstmt != null) pstmt.close();
	 		}
	 		catch(Exception e){
	 			System.out.println("");
	 		}
	 		try{
	 			if(con != null) con.close();
	 		}
	 		catch(Exception e){
	 			System.out.println("");
	 		}
	 	}
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr);
		popUp("등록 성공");
		
	}
	
	void selectAll() {
		//테이블 초기화
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		String id = null, nickName = null, today = null, 
				start_time = null, end_time = null, study_time = null;
		
		TimeVO vo = new TimeVO(id, nickName, today, start_time, end_time, study_time);
		
	 	PreparedStatement pstmt1 = null;
	 	PreparedStatement pstmt2 = null;
	 	
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		String sql1 = "select count(*) from timelog";
		String sql2 = "select * from userInfo u, timelog t where u.id = t.id order by study_time";
		Connection con = null;
		
		try{
			con = connectDB();
			
			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			rs1.next();
			
			if(rs1.getInt(1) == 0)
				popUp("출력할 데이터가 없습니다.");
			else {
				pstmt2 = con.prepareStatement(sql2);
				rs2 = pstmt2.executeQuery();
				
				while(rs2.next()){
					
					vo.id = rs2.getString("id");
					vo.nickName = rs2.getString("nickname");
					vo.today = rs2.getString("today");
					vo.start_time = rs2.getString("start_time");
					vo.end_time = rs2.getString("end_time");
					vo.study_time = rs2.getString("study_time");
					System.out.println(vo.id);
					System.out.println(vo.today);
					System.out.println(vo.start_time);
					selectIntoTable(vo);
				}
				popUp("출력 성공");
			}
		}
		catch(Exception e){
			System.out.println("오류오류");
		}
		finally{
			try{
			
				if(rs1 != null) rs1.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			}
			catch(Exception e){
				System.out.println("jdbc 객체 close error");
			}
		}
	}
	void updateIntoTable(TimeVO obj) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		int colNum = table.getColumnCount();
		String arr [] = new String[colNum];
		
		arr[0] = obj.id;
		arr[2] = obj.today;
		arr[3] = obj.start_time;
		
		model.addRow(arr);
		
	}
	
	void selectIntoTable(TimeVO obj) {
		
		int colNum = table.getColumnCount();
		String arr [] = new String[colNum];
		
		arr[0] = obj.id;
		arr[1] = obj.nickName;
		arr[2] = obj.today;
		arr[3] = obj.start_time;
		arr[4] = obj.end_time;
		arr[5] = obj.study_time;
	
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr);
		
	}
	void timeStart() {
		
		String id = textField[0].getText();
		
		TimeVO vo = new TimeVO(id);
		
		//System.out.println("디버깅 : " + id);
		//System.out.println(vo.start_time);
		
		// 여기서부터 렉이 걸리는 이유가 왜일까. => 해결. 그냥 해결됨.
		
		// 아래부터 jdbc update하기
		Connection con = null;
	 	con = connectDB();
	 	PreparedStatement pstmt = null;
	 	
	 	String sql = "update timelog set start_Time = ? where ID = ?";
		
	 	try{
	 		pstmt = con.prepareStatement(sql);
	 		pstmt.setString(1, vo.start_time);
	 		pstmt.setString(2, id);
	 
	 		int res = pstmt.executeUpdate();
	 		
	 		if(res == 1) {
	 			updateIntoTable(vo);
	 			System.out.println("jdbc update successs!");
	 		}
	 		else
	 			System.out.println("This is update() : failed to connection");
	 	}
	 	catch(Exception e){
	 		popUp("데이터베이스 오류입니다." + e.getMessage());
	 	}
	 	finally{
	 		try{
	 			if(pstmt != null) pstmt.close();
	 		}
	 		catch(Exception e){
	 			System.out.println("pstmt.close() 오류");
	 		}
	 		try{
	 			if(con != null) con.close();
	 		}
	 		catch(Exception e){
	 			System.out.println("con.close() 오류");
	 		}
	 	}
	 	System.out.println("timeStart() 메서드 마지막 라인");
	}
	
	public Connection connectDB(){
		 
		Connection con = null;
	 	
	 	try{
	 		String driver = "oracle.jdbc.driver.OracleDriver";
	 		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
	 		
	 		Class.forName(driver);
	 		con = DriverManager.getConnection(url, "scott", "123456");
	 	}
	 	catch(Exception e){
		 		System.out.println("This is ConnectDB : failed to connection!" );
		 		popUp("failed to connection!");
		 		e.printStackTrace( );
	 	}
	 	return con;
	 }
	
	void popUp(String message) {
		JOptionPane.showMessageDialog(null, message);
		for(JTextField dat : textField) {
			dat.setText("");
		}
	}
	
}
