package com.example.demo.mapper;

import com.example.demo.dto.UserEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

     UserEntity getUser(UserEntity userCondition);

     void saveUser(UserEntity userCondition);

}
