package com.lzb.test;


import org.junit.Test;

import com.lzb.oa.dao.UserDao;

public class UserDAOTest {

	@Test
	public void testChangePass(){
		int flag  = UserDao.getInstance().modifyPassword("root", "11111", "2222");
		System.out.println("flag = " + flag);
	}
}
