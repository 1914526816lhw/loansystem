package com.stu.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.PassToken;
import com.stu.annotation.UserLoginToken;
import com.stu.entity.Guardian;

import com.stu.entity.Users;
import com.stu.service.GuardianService;
import com.stu.service.LoanContractService;
import com.stu.service.UsersService;
import com.stu.util.DateUtilCurrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * ClassName：UsersController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/15 12:33
 * @version 1.0.0
 */

@RestController
@RequestMapping("/user")
public class UsersController {


    @Autowired
    private UsersService usersService;
    @Autowired
    private LoanContractService loanContractService;
    @Autowired
    private GuardianService guardianService;

    /**
     * MethodName: register
     * Description:用户注册接口
     *
     * @param
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 14:36
     */
    @PassToken
    @RequestMapping("/register")
    public JSONObject register(String userName, String userIdentity, String userSecurityQuestion, String userSecurityAnswer, String userPassword, String userPhone) {
        return usersService.registerUsers(userName, userIdentity, userSecurityQuestion, userSecurityAnswer, userPassword, userPhone);
    }

    /**
     * MethodName: verifyUser
     * Description:验证用户身份证号
     *
     * @param userIdentity
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 14:35
     */
    @PassToken
    @RequestMapping("/verifyUser")
    public JSONObject verifyUser(String userIdentity) {
        return usersService.selectUserByUserIdentity(userIdentity);
    }


    /**
     * MethodName: selectPhoneByIdentity
     * Description: 通过用户身份证号查找手机号接口
     *
     * @param userIdentity
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 14:43
     */
    @PassToken
    @RequestMapping("/selectPhoneByIdentity")
    public JSONObject selectPhoneByIdentity(String userIdentity) {
        return usersService.selectPhoneByUserIdentity(userIdentity);
    }

    /**
     * MethodName: selectSecurityByIdentity
     * Description: 通过用户身份证号查找密保问题
     *
     * @param userIdentity
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 16:13
     */
    @PassToken
    @RequestMapping("/selectSecurityByIdentity")
    public JSONObject selectSecurityByIdentity(String userIdentity) {
        return usersService.selectSecurityByUserIdentity(userIdentity);
    }

    /**
     * MethodName: updateSecurityQuestion
     * Description: 修改密保问题
     *
     * @param userLoginAccount,userSecurityQuestion,userSecurityAnswer
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/4/1 17:34
     */
    @UserLoginToken
    @RequestMapping("/updateSecurityQuestion")
    public JSONObject updateSecurityQuestion(String userLoginAccount, String userSecurityQuestion, String userSecurityAnswer) {
        return usersService.updateSecurityQuestion(userLoginAccount, userSecurityQuestion, userSecurityAnswer);
    }

    @UserLoginToken
    @RequestMapping("/updateUserPhone")
    public JSONObject updateUserPhone(String userLoginAccount, String newPhone, String verifyCode) {
        return usersService.updateUserPhone(userLoginAccount, newPhone, verifyCode);
    }

    @UserLoginToken
    @RequestMapping("/isFirstLoan")
    public JSONObject isFirstLoan(String userLoginAccount) {
        return usersService.isFirstLoan(userLoginAccount);
    }

    /**
     * MethodName: getUserName
     * Description: 获取用户名
     *
     * @param userLoginAccount
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/4/1 17:35
     */
    @UserLoginToken
    @RequestMapping("/getUserName")
    public JSONObject getUserName(String userLoginAccount) {
        return usersService.getUserName(userLoginAccount);
    }


    @UserLoginToken
    @RequestMapping("/improveUserInfo")
    public JSONObject improveUserInfo(
            String userLoginAccount, String userSex,Date userBirthday, int userFamousRaceId, String userMiddleSchool,
            int accountCharacterId, int fundingCenterId, String areaId,
            String userPermanentAddress,String userBankCardId, String userPostalCode, String userMailBox, String userQq, String userWeChat,
            String userPostalAddress, String userFamilyPhone, String userContactName, String userContactPhone,
            String userContactIdentity, String userUniversity, String userDepartment, String userMajor,
            String userEducation, int userEnrollmentYear, String userStudentId, String userMajorCategory,
            String userEducationalSystem, Date userGraduationTime,String relation,
            String guardianName, String guardianIdentity, String guardianAreaId, String guardianPermanentAddress,
            String guardianPostalCode, String guardianHealth, String guardianTel) {
        //添加共同贷款人
        Guardian guardian = new Guardian();
        guardian.setGuardianName(guardianName);
        guardian.setGuardianIdentity(guardianIdentity);
        guardian.setAreaId(guardianAreaId);
        guardian.setGuardianPermanentAddress(guardianPermanentAddress);
        guardian.setGuardianPostalCode(guardianPostalCode);
        guardian.setGuardianHealth(guardianHealth);
        guardian.setGuardianTel(guardianTel);


        Users user = new Users();
        user.setUserIdentity(userLoginAccount);
        user.setUserSex(userSex);
        user.setUserBirthday(userBirthday);
        user.setUserFamousRaceId(userFamousRaceId);
        user.setUserMiddleSchool(userMiddleSchool);
        user.setAccountCharacterId(accountCharacterId);
        user.setFundingCenterId(fundingCenterId);
        user.setAreaId(areaId);
        user.setUserPermanentAddress(userPermanentAddress);
        user.setUserPostalCode(userPostalCode);
        user.setUserMailBox(userMailBox);
        user.setUserQq(userQq);
        user.setUserWechat(userWeChat);
        user.setUserPostalAddress(userPostalAddress);
        user.setUserFamilyPhone(userFamilyPhone);
        user.setUserContactName(userContactName);
        user.setUserContactIdentity(userContactIdentity);
        user.setUserContactPhone(userContactPhone);
        user.setUserUniversity(userUniversity);
        user.setUserDepartment(userDepartment);
        user.setUserMajor(userMajor);
        user.setUserEducation(userEducation);
        user.setUserEnrollmentYear(userEnrollmentYear);
        user.setUserStudentId(userStudentId);
        user.setUserMajorCategory(userMajorCategory);
        user.setUserEducationalSystem(userEducationalSystem);
        user.setUserGraduationTime(userGraduationTime);
        user.setRelation(relation);
        user.setUserBankCardId(userBankCardId);
        System.out.println(user.toString());
        return usersService.improveUserInfo(guardian, user);
    }

    /**
     * MethodName: getUserInfo
     * Description: 根据用户账号获取用户信息
     *
     * @param userLoginAccount
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/4/4 16:51
     */
    @UserLoginToken
    @RequestMapping("/getUserInfo")
    public JSONObject getUserInfo(String userLoginAccount) {
        return usersService.getUserInfo(userLoginAccount);
    }


    /**
     * MethodName: updateUser
     * Description: 修改用户信息
     * @author lihw
     * CreateTime 2020/4/4 17:25
     * @param
     * @return jsonObject
     */
    @UserLoginToken
    @RequestMapping("/updateUser")
    public JSONObject updateUser(String userLoginAccount, String userSex,Date userBirthday, String userMiddleSchool,
           String userPostalCode, String userMailBox, String userQq, String userWeChat,
            String userPostalAddress, String userFamilyPhone, String userContactName, String userContactPhone,
            String userContactIdentity, String userDepartment, String userMajor,
            String userStudentId, String userMajorCategory, String changeReason){
        Users user = new Users();
        user.setUserIdentity(userLoginAccount);
        user.setUserSex(userSex);
        user.setUserBirthday(DateUtilCurrent.addDate(userBirthday));
        user.setUserMiddleSchool(userMiddleSchool);
        user.setUserPostalCode(userPostalCode);
        user.setUserMailBox(userMailBox);
        user.setUserQq(userQq);
        user.setUserWechat(userWeChat);
        user.setUserPostalAddress(userPostalAddress);
        user.setUserFamilyPhone(userFamilyPhone);
        user.setUserContactName(userContactName);
        user.setUserContactIdentity(userContactIdentity);
        user.setUserContactPhone(userContactPhone);
        user.setUserDepartment(userDepartment);
        user.setUserMajor(userMajor);
        user.setUserStudentId(userStudentId);
        user.setUserMajorCategory(userMajorCategory);
        return usersService.updateUser(user,changeReason);
    }

    @UserLoginToken
    @RequestMapping("/getAllLoanContract")
    public JSONObject getUserAllLoanContract(String userLoginAccount){
        return loanContractService.getAllLoanContractByUserIdentity(userLoginAccount);
    }

    @UserLoginToken
    @RequestMapping("/getUserDetail")
    public JSONObject getUserDetail(String userLoginAccount){
        JSONObject userJson = usersService.getUserInfoDetail(userLoginAccount).getJSONObject("data").getJSONObject("user");
        JSONObject guardianJson = guardianService.getGuardianUserInfoDetail(userLoginAccount).getJSONObject("data").getJSONObject("guardian");

        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        jsonObject.put("status",200);
        data.put("user",userJson);
        data.put("guardian",guardianJson);
        jsonObject.put("data",data);
        return jsonObject;
    }

}
