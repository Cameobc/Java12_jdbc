package com.sesung.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sesung.db.util.DBConnector;

public class PointInsert {
	public static void main(String[] args) {
		//id, 국, 영, 수, 입력
		try {
			new PointController().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			Connection con =DBConnector.getConnect();
//			String sql = "INSERT INTO POINT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//			st = con.prepareStatement(sql);
//			System.out.println("id");
//			sid = sc.next();
//			System.out.println("kor");
//			kor = sc.nextInt();
//			System.out.println("eng");
//			eng = sc.nextInt();
//			System.out.println("math");
//			math = sc.nextInt();
//			total = eng+kor+math;
//			avg = total/3;
//			st.setString(1, sid);
//			st.setInt(2, kor);
//			st.setInt(3, eng);
//			st.setInt(4, math);
//			st.setInt(5, total);
//			st.setDouble(6, avg);
//			result = st.executeUpdate();
//			
//			sql = "SELECT * FROM POINT";
//			st = con.prepareStatement(sql);
//			rs = st.executeQuery();
//			while(rs.next()) {
//				System.out.println("ID : "+rs.getString(1));
//				System.out.println("Kor : "+rs.getInt(2));
//				System.out.println("Eng : "+rs.getInt(3));
//				System.out.println("Math : "+rs.getInt(4));
//				System.out.println("Total : "+rs.getInt(5));
//				System.out.println("Avg : "+rs.getDouble(6));
//				System.out.println("======================");
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				st.close();
//				sc.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if(result>0) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
		
	}

}
