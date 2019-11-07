/*
package com.example.demo.service;

import com.example.demo.dto.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserMapper membersMapper;

    @InjectMocks
    private UserService membersService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMembersById() {
        UserEntity u = new UserEntity();
        //when(membersMapper.selectByPrimaryKey(3)).thenReturn(m);
        UserEntity result = membersService.getUserById(u);
        System.out.println(result);

    }
}*/
