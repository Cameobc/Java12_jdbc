package com.seseung.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		//1.4가지 정보
		String user = "scott";
		String pw = "tiger";
		String url="jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//2.드라이버를 메모리에 로딩
		
		try {
			Class.forName(driver);
			//3.connection
			con = DriverManager.getConnection(url, user, pw);
			//4.SQL문
			String sql = "SELECT * FROM DEPT ORDER BY DEPTNO DESC";
			//5.미리전송
			st= con.prepareStatement(sql);
			//6.?세팅
			//7.최종전송 후 결과처리
			rs = st.executeQuery();
			while(rs.next()) {
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부서명   : "+rs.getString("dname"));
				System.out.println("지역명   : "+rs.getString("loc"));
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
