package org.luis.mybatis;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.luis.mybatis.domain.User;
import org.luis.mybatis.service.UserService;

import static org.junit.Assert.*;

public class UserServiceTest {
	
	private static UserService userService;
	
	
	@BeforeClass
	public static void setUpBeforeClass(){
		userService = new UserService();
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		userService = null;
	}
	
	@Test
	public void testGetUserById(){
		User user = userService.getUserById(1);
		assertNotNull(user);
		System.out.println(user);
	}
	
	@Test
	public void testGetAllUsers(){
		List<User> users = userService.getAllUsers();
		assertNotNull(users);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setEmailId("testEmail" + System.currentTimeMillis() + "@gmail.com");
		user.setPassword("secrect");
		user.setFirstName("testFirstName");
		user.setLastName("testLastName");
		
		userService.insertUser(user);
		assertTrue(user.getUserId() != 0);
		User createdUser = userService.getUserById(user.getUserId());
		assertEquals(user.getEmailId(), createdUser.getEmailId());
		assertEquals(user.getPassword(), createdUser.getPassword());
		assertEquals(user.getFirstName(), createdUser.getFirstName());
		
	}
	
	@Test
	public void testUpdateUser(){
		long timestamp = System.currentTimeMillis();
		User user = userService.getUserById(1);
		user.setFirstName("testFirstName" + timestamp);
		user.setLastName("testLastName" + timestamp);
		userService.updateUser(user);
		
		User updatedUser = userService.getUserById(1);
		assertEquals(user.getFirstName(), updatedUser.getFirstName());
		assertEquals(user.getLastName(), updatedUser.getLastName());
	}
	

	@Test
	public void testDeleteUser(){
		User user = userService.getUserById(2);
		userService.deleteUser(user.getUserId());
		User deletedUser = userService.getUserById(4);
		assertNull(deletedUser);
	}
	
}
