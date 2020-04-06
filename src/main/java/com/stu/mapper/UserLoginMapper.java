package com.stu.mapper;

import com.stu.entity.UserLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginMapper {
//    int deleteByPrimaryKey(Integer userLoginId);
//
//    int insert(UserLogin record);
//
//    int insertSelective(UserLogin record);
//
//    UserLogin selectByPrimaryKey(Integer userLoginId);
//
//    int updateByPrimaryKeySelective(UserLogin record);
//
//    int updateByPrimaryKey(UserLogin record);

    int insertUserLogin(String userLoginAccount,String userLoginPassword,int userId)throws Exception;
    UserLogin selectUserLoginByAccount(String userLoginAccount);
    int resetPwd(String userLoginAccount,String userLoginPassword);
}