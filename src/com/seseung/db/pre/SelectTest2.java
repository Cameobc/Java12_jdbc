package com.seseung.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		ResultSet rs = null;
		int result = 0;
		
		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		System.out.println("조회할 부서 번호 입력");
		result = sc.nextInt();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM DEPT WHERE DEPTNO=?";
			st = con.prepareStatement(sql);
			st.setInt(1, result);
			rs = st.executeQuery();
			if(rs.next()) {
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부서명    : "+rs.getString("dname"));
				System.out.println("부서위치 : "+rs.getString("loc"));
			}else {
				System.out.println("없는 번호 입니다.");
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
