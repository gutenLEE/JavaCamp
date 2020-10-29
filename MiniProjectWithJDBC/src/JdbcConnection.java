import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

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
			System.out.println(arr[i]); // ��ü�� ������ �� �ϰ� �ֱ�...
		}
		
		// �Ʒ����� jdbc insert�ϱ�
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
	 		popUp("�����ͺ��̽� �����Դϴ�." + e.getMessage());
	 		e.printStackTrace();
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
		popUp("��� ����");
		
	}
	
	void selectAll() {
		//���̺� �ʱ�ȭ
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
				popUp("����� �����Ͱ� �����ϴ�.");
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
					System.out.println("���� ��¥ : " + vo.today);
					System.out.println("���� �ð�" + vo.start_time);
					selectIntoTable(vo);
				}
				popUp("��� ����");
			}
		}
		catch(Exception e){
			System.out.println("��ü ��ȸ ����");
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
				System.out.println("jdbc ��ü close error");
			}
		}
	}
	void updateIntoTable(TimeVO obj) {
		
	 	PreparedStatement pstmt_date = null;
		ResultSet rs1 = null;
		
		String sql1 = "select today from timelog where id = ?";
		Connection con = null;
		
		try{
			con = connectDB();
			pstmt_date = con.prepareStatement(sql1);
			pstmt_date.setString(1, obj.id);
			System.out.println("obj.id ==================>" + obj.id);
			rs1 = pstmt_date.executeQuery();
			System.out.println("0");
			rs1.next();
			System.out.println("00");
			
			if(!rs1.next()) {
				System.out.println("0000000000000000");
				popUp("����� �����Ͱ� �����ϴ�.");
			}
			else {
				while(rs1.next()){
					java.sql.Date date = rs1.getDate(1);
					java.sql.Time time = rs1.getTime(1);
					java.util.Date utilDate = new java.util.Date(date.getTime());
					System.out.println("utilDate" + utilDate);
					
					System.out.println("��¥ �׽�Ʈ�̿����" + date);
					System.out.println("�ð� �׽�Ʈ�̿���" + time);
	
//					vo.start_time = rs2.getString("start_time");
					System.out.println(obj.id);
				}
				popUp("��� ����");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("��¥�� ��ȸ ���� : " + e.getMessage());
		}
		finally{
			try{
				if(rs1 != null) rs1.close();
				if(pstmt_date != null) pstmt_date.close();
				if(con != null) con.close();
			}
			catch(Exception e){
				System.out.println("jdbc ��ü close error");
			}
		}
		
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
		String id = null;
		TimeVO vo = new TimeVO(id);
		vo.id = textField[0].getText();
		System.out.println("���̵�=========================" + vo.id);	
		
		//System.out.println("����� : " + id);
		//System.out.println(vo.start_time);
		
		// �Ʒ����� jdbc update�ϱ�
		Connection con = null;
	 	con = connectDB();
	 	PreparedStatement pstmt = null;
	 	
	 	String sql = "insert into timelog(id, today, start_time) values(?, sysdate, sysdate)";
		
	 	try{
	 		pstmt = con.prepareStatement(sql);
	 		pstmt.setString(1, vo.id);
	 
	 		int res = pstmt.executeUpdate();
	 		
	 		if(res == 1) {
	 			// ���̺� ��� ����ϴ� �޼���
	 			System.out.println("jdbc timeStart successs!");
	 			updateIntoTable(vo);
	 		}
	 		else
	 			System.out.println("This is timeStart() : failed to connection");
	 	}
	 	catch(Exception e){
	 		popUp("time_start �����ͺ��̽� �����Դϴ�." + e.getMessage());
	 	}
	 	finally{
	 		try{
	 			if(pstmt != null) pstmt.close();
	 		}
	 		catch(Exception e){
	 			System.out.println("pstmt.close() ����");
	 		}
	 		try{
	 			if(con != null) con.close();
	 		}
	 		catch(Exception e){
	 			System.out.println("con.close() ����");
	 		}
	 	}
	 	System.out.println("timeStart() �޼��� ������ ����");
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
