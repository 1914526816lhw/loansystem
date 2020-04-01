package com.stu.mapper;

import com.stu.entity.UserLogin;
import com.stu.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
//    int deleteByPrimaryKey(Integer userId);
//
//    int insert(Users record);
//
//    int insertSelective(Users record);
//
//    Users selectByPrimaryKey(Integer userId);
//
//    int updateByPrimaryKeySelective(Users record);
//
//    int updateByPrimaryKey(Users record);

//    int registerUsers(String userName, String userIdentity, String userSecurityQuestion, String userSecurityAnswer, String userPhone) throws Exception;
    int registerUsers(Users users);
    UserLogin selectUserLoginByPhone(String userPhone);
    Users selectUserByIdentity(String userIdentity);
    int updateSecurityQuestion(String userIdentity,String userSecurityQuestion,String userSecurityAnswer);
    int updateUserPhone(String userIdentity,String userPhone) throws Exception;
}