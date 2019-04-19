package com.seseung.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {
	public static void main(String[] args) {
		//부서번호, 부서명, 지역명을 입력받아서
		//dept insert
		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		String no = null;
		String dept = null;
		String city = null;
		Scanner sc = new Scanner(System.in);
		Statement st = null;
		int result = 0;

		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결성공");
			System.out.println("부서코드 입력");
			no = sc.next();
			System.out.println("부서명 입력");
			dept = sc.next();
			System.out.println("도시명 입력");
			city = sc.next();
			String sql = "INSERT INTO DEPT VALUES('"+no+"','"+dept+"','"+city+"')";
			st = con.createStatement();
			result = st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
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
