package com.seseung.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  st = null;
		
		int deptno = 50;
		String dname = "it";  // 나중에 스캐너로 바꿔서 해보기
		String loc= "paris";
		int result = 0;
		//1.로그인 정보 4가지
		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2.드라이버 메모리에 로딩. 
		try {
			Class.forName(driver);
		//3.로그인 후 Connection 객체 받아오기
			con = DriverManager.getConnection(url, user, pw);
		
		//4.SQL문 작성 -> 컬럼명/테이블명을 물음표로 하는 것은 불가능하다.
			String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
			
		//5.SQL문 미리 전송	
			st = con.prepareStatement(sql);
			
		//6.?에 대한 값을 세팅
		//st.set***(?의 인덱스번호, 해당하는값);
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);
		//7.최종전송 후 처리
			result = st.executeUpdate();
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
