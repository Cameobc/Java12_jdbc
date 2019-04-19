package com.sesung.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {

	public static Connection getConnect() throws Exception {
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		return con;
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception{
		st.close();
		con.close();
	}
	
	public static void disConnect(PreparedStatement st, Connection con, ResultSet re) throws Exception{
		re.close();  //this ->자기 자신의 객체의 주소
		DBConnector.disConnect(st, con);
	}
}
