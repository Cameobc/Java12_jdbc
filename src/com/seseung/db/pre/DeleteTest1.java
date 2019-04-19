package com.seseung.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest1 {
	public static void main(String[] args) {
		//부서번호를 입력 받아서, dept 테이블에서 삭제.
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = null;
		int deptno = 0;
		int  result = 0;
		
		
		//1.로그인정보4가지
		String user = "scott";
		String pw = "tiger";
		String url ="jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 드라이버를 메모리에 로딩
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결성공");
			//3.SQL문 작성
			String sql = "Delete dept WHERE DEPTNO=?";
			//4.SQL값 미리 전송
			ps = con.prepareStatement(sql);
			//5.?값 세팅
			System.out.println("삭제할 부서 번호 입력");
			deptno = sc.nextInt();
			ps.setInt(1, deptno);
			//6.최종전송 후 결과 처리
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				sc.close();
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
