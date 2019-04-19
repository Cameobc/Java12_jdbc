package com.sesung.db.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sesung.db.point.PointDAO;

public class PointDAOTest {

	@Test
	public void test() throws Exception {
		int result = PointDAO.insert(null);
		assertEquals(1, result);
	}

}
