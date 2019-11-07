package com.example.demo;

import com.example.demo.dto.UserEntity;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by admin on 2017/9/21-11:33.
 * Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	public void insertTest() throws Exception {
		UserEntity u = new UserEntity();
		u.setUserId(2);
		u.setUserName("zhaofei");
		u.setPassword("123456");
		u.setIdCard("340826199999999999");
		u.setPhone("18805607817");
		userService.saveUser(u);

		UserEntity u2 = new UserEntity();
		u2.setUserName("zhaofei");
		u2.setPassword("123456");

		assert(userService.login(u2));
	}
}
