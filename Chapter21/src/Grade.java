import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Grade implements Serializable, Cloneable {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
	Connection conn = null;
	CallableStatement cstmt = null;
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String hakbun, name, grade;
	int kor, eng, math, tot;
	double avg;
	
	Grade(){
		
	}
	
	void InsertSungjuk(){
		/*
		 create or replace procedure call_insert2(hakbun sungjuk.hakbun%type,
                                        irum sungjuk.irum%type,
                                        kor sungjuk.kor%type,
                                        eng sungjuk.eng%type,
                                        math sungjuk.math%type,
                                        tot sungjuk.tot%type,
                                        avg sungjuk.avg%type,
                                        grade sungjuk.grade%type)
			is
			begin
			    insert into sungjuk(hakbun, irum, kor, eng, math, tot, avg, grade) values(hakbun, irum, kor, eng, math, tot, avg, grade);
			end;
			/
		 */
		
		avg = 0;
		hakbun = "";
		
		try {
			
			System.out.println("Insert Score to Sungjuk table");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
			
			System.out.println("Name => ");
			name = br.readLine();
			
			System.out.println("kor => ");
			kor = Integer.parseInt(br.readLine());
			
			System.out.println("eng => ");
			eng = Integer.parseInt(br.readLine());
			
			System.out.println("math => ");
			math = Integer.parseInt(br.readLine());
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_insert2(?, ?, ?, ?, ?, ?, ?, ?)}");
			cstmt.setString(1, hakbun);
			cstmt.setString(2, name);
			cstmt.setInt(3, kor);
			cstmt.setInt(4, eng);
			cstmt.setInt(5, math);
			getGrade();
			cstmt.setInt(6, tot);
			cstmt.setString(7, Double.toString(avg));
			cstmt.setString(8, grade);
			
			cstmt.executeUpdate();
//			int res = cstmt.executeUpdate();
//			System.out.println(res);
			
			System.out.println("successful connection!");
		}
		catch(Exception e) {
			System.out.println("failed to connection" + e.getMessage());
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
	
	void getGrade() {
		
		tot = eng + kor + math;
		avg = tot / 3.;
		
	
		if(avg >= 90)
			grade = "수";
		if( avg >= 80 && avg < 90)
			grade = "우";
		if( avg >= 70 && avg < 80)
			grade = "미";
		if( avg >= 60 && avg < 70)
			grade = "양";
		if( avg < 60)
			grade = "가";
	}
	
	static void getTotalAvg() {
		return;
	}
	
	void readGradeSheet() {
		
		ResultSet rs = null;
		
		try {
			
			System.out.println("Select Score from Sungjuk table");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_select_all(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);
			
			
			System.out.println("hakbun   /   irum /    kor /    eng  /   math  /   tot /   avg  /   grade  ");
			System.out.println("==========================================================================");
			
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("irum") + "\t");
				System.out.print(rs.getString("kor") + "\t");
				System.out.print(rs.getInt("eng") + "\t");
				System.out.print(rs.getInt("kor") + "\t");
				System.out.print(rs.getInt("math") + "\t");
				System.out.print(rs.getInt("tot") + "\t");
				System.out.print(rs.getString("avg") + "\t");
				System.out.print(rs.getString("grade") + "\n");
			}
	

		}
		catch(Exception e) {
			System.out.println("failed to connection" + e.getMessage());
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(cstmt != null) cstmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	void updateGradeSheet() {
		avg = 0;
		
		try {
			System.out.println("update sungjuk from table...");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
			
			System.out.println("kor => ");
			kor = Integer.parseInt(br.readLine());
			
			System.out.println("eng => ");
			eng = Integer.parseInt(br.readLine());
			
			System.out.println("math => ");
			math = Integer.parseInt(br.readLine());
			
			getGrade();
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_update_sungjuk(?, ?, ?, ?, ?, ?)}");
			cstmt.setInt(1, eng);
			cstmt.setInt(2, kor);
			cstmt.setInt(3, math);
			cstmt.setInt(4, tot);
			cstmt.setString(5, Double.toString(avg));
			cstmt.setString(6, grade);
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
	
	void delete() {
		
		try {
			
			System.out.println("delete data from table...");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
		
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_delete_Sungjuk(?)}");
			cstmt.setString(1, hakbun);
			cstmt.executeUpdate();
			
			int res = cstmt.executeUpdate();
			System.out.println(res);
			
			System.out.println("successful connection!");
			
		}catch(Exception e) {
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
	
	void searchGradeSheet() {
		ResultSet rs = null;
		
		try {
			
			System.out.println("Select Score from Sungjuk table");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "123456");
			
			cstmt = conn.prepareCall("{call call_select_one(?, ?)}");
			
			System.out.println("hakbun => ");
			hakbun = br.readLine();
			
			cstmt.setString(1, hakbun);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(2);
			System.out.println("re : " + rs);
			
			System.out.println("hakbun   /   irum /  kor /  eng  / math  / tot / avg  / grade  ");
			System.out.println("===============================================================");
			
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("irum") + "\t");
				System.out.print(rs.getString("kor") + "\t");
				System.out.print(rs.getInt("eng") + "\t");
				System.out.print(rs.getInt("kor") + "\t");
				System.out.print(rs.getInt("math") + "\t");
				System.out.print(rs.getInt("tot") + "\t");
				System.out.print(rs.getString("avg") + "\t");
				System.out.print(rs.getString("grade") + "\n");
			}
	

		}
		catch(Exception e) {
			System.out.println("failed to connection" + e.getMessage());
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(cstmt != null) cstmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
			