package com.sesung.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.sesung.db.util.DBConnector;

public class PointDAO {
	
//	public static int delete(PointDTO pointDTO) throws Exception {
//		Connection con = DBConnector.getConnect();
//		String sql = "DELETE POINT WHERE NUM=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		
//		
//		return result;
//	}
	
	public static int insert(PointDTO pointdto) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "INSERT INTO POINT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st=con.prepareCall(sql);
		
		st.setInt(1, pointdto.getNum());
		st.setString(2, pointdto.getSid());
		st.setInt(3, pointdto.getKor());
		st.setInt(4, pointdto.getEng());
		st.setInt(5, pointdto.getMath());
		st.setInt(6, pointdto.getTotal());
		st.setDouble(7, pointdto.getAvg());
		st.setInt(8, pointdto.getBnum());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
		
	}

}
