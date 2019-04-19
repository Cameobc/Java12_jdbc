package com.seseung.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class InsertTest3 {
	public static void main(String[] args) {
		//dept no 30, comm 0, salary 1000, hiredate 오늘날짜, mgr은empno중 하나가 되어야 함
		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sp = new SimpleDateFormat("yy/MM/dd");	
		String day=sp.format(cal.getTime());
		Statement st = null;
		int result = 0;
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("사번입력");
			int empno = sc.nextInt();
			System.out.println("직원명 입력");
			String name = sc.next();
			System.out.println("직업 입력");
			String job = sc.next();
			System.out.println("상사사번입력");
			String mgr = sc.next();
			String sql = "INSERT INTO EMP VALUES("+ empno+""+", '"+name+"', '"+job+"', '"
			+mgr+"', '"+day+"', 1000, 0, 30)";
			System.out.println(sql);
			st = con.createStatement();
			result = st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}

}
