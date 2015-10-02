package com.lzb.test;

import java.io.IOException;

import org.junit.Test;

import com.lzb.oa.dao.UserDAO;

public class UserDAOTest {

	@Test
	public void testChangePass(){
		int flag = 0;
		try {
			flag = UserDAO.getInstance().ChangePassword("root", "11111", "2222");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("flag = " + flag);
	}
}
