package com.seseung.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest3 {
	public static void main(String[] args) {
		//dept 부서의 개수는 총 몇개?
		//부서번호가 제일 큰것과 제일 작은 것
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			String sql = "select count(deptno), min(deptno), max(deptno) as m from dept";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
//			if(rs.next()) {
			rs.next();
			System.out.println("부서의 수 : "+rs.getInt(1)+" 가장 큰 부서번호 : "+rs.getInt("m")+" 가장 작은 부서번호 : "+rs.getInt("min(deptno)"));
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
