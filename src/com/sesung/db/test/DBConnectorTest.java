package com.sesung.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.sesung.db.util.DBConnector;

public class DBConnectorTest {
	//Annotation : 설명+실행기능
	@Test  
	public void test() throws Exception {
		Connection con = DBConnector.getConnect();
		assertNotNull(con);
	}

}
