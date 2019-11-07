package com.example.demo.service;

import com.example.demo.dto.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.AesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public void saveUser(UserEntity userCondition) throws Exception {
        userCondition.setPassword(encryptedPassword(userCondition.getPassword(), "123"));
        userCondition.setPhone(AesUtil.Encrypt(userCondition.getPhone(), "1234567890123456"));
        userCondition.setIdCard(AesUtil.Encrypt(userCondition.getIdCard(), "1234567890123456"));
        userMapper.saveUser(userCondition);
    }

    public boolean login(UserEntity userCondition){
        String md5Passwrod = encryptedPassword(userCondition.getPassword(), "123");
        UserEntity user = userMapper.getUser(userCondition);
        if(user == null || !md5Passwrod.equals(user.getPassword())){
            logger.info("登录失败");
            return  false;
        }
        logger.info("登录成功");
        //得到session对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return true;
    }

    public String encryptedPassword(String pwd, String salt) {
        String pwdSalt = new Md5Hash(pwd, salt, 3).toString();
        return pwdSalt;
    }


}
