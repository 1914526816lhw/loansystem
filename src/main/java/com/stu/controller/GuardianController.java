package com.stu.controller;


import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.entity.Guardian;
import com.stu.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guardian")
public class GuardianController {

    @Autowired
    private GuardianService guardianService;


    /**
     * MethodName: hasGuardian
     * Description: 判断用户是否需要完善个人信息（即判断是否有共同贷款人）
     *
     * @param userLoginAccount
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/4/4 21:29
     */
    @UserLoginToken
    @RequestMapping("/hasGuardian")
    public JSONObject hasGuardian(String userLoginAccount) {
        return guardianService.getGuardianByUserIdentity(userLoginAccount);
    }

    @UserLoginToken
    @RequestMapping("/getGuardianInfo")
    public JSONObject getGuardianInfo(String userLoginAccount) {
        return guardianService.getGuardianInfo(userLoginAccount);
    }

    @UserLoginToken
    @RequestMapping("/updateGuardian")
    public JSONObject updateGuardian(
            String userLoginAccount, String guardianName, String guardianIdentity, String guardianAreaId, String guardianPermanentAddress,
            String guardianPostalCode, String guardianHealth, String guardianTel, String changeReason) {
        Guardian guardian = new Guardian();
        guardian.setUserIdentity(userLoginAccount);
        guardian.setGuardianName(guardianName);
        guardian.setGuardianIdentity(guardianIdentity);
        guardian.setAreaId(guardianAreaId);
        guardian.setGuardianPermanentAddress(guardianPermanentAddress);
        guardian.setGuardianPostalCode(guardianPostalCode);
        guardian.setGuardianHealth(guardianHealth);
        guardian.setGuardianTel(guardianTel);

        guardian.toString();
        return guardianService.updateGuardian(guardian,changeReason);
    }

}
