package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.ChangeLog;
import com.stu.entity.Guardian;
import com.stu.mapper.AreasMapper;
import com.stu.mapper.ChangeLogMapper;
import com.stu.mapper.GuardianMapper;
import com.stu.mapper.UsersMapper;
import com.stu.vo.AreasVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName：GuardianServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/4 15:16
 * @version 1.0.0
 */
@Service
public class GuardianServiceImpl implements GuardianService {

    @Autowired
    private GuardianMapper guardianMapper;
    @Autowired
    private ChangeLogMapper changeLogMapper;
    @Autowired
    private AreasMapper areasMapper;


    /**
     * MethodName: getGuardianByUserIdentity
     * Description: 通过userIdentity判断是否有共同贷款人
     *
     * @param userIdentity
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/4/4 15:21
     */
    @Override
    public JSONObject getGuardianByUserIdentity(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        Guardian guardian = guardianMapper.selectByUserIdentity(userIdentity);
        if (guardian != null) {
            jsonObject.put("status", 200);

        } else {
            jsonObject.put("status", 401);
        }

        return jsonObject;

    }

    @Override
    public JSONObject getGuardianInfo(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Guardian guardian = guardianMapper.selectByUserIdentity(userIdentity);
//        AreasVo areasVo = areasMapper.selectAreaVoByAreaId(guardian.getAreaId());
        if (guardian != null) {
            jsonObject.put("status", 200);
//            guardian.setProvinceId(areasVo.getProvinceId());
//            guardian.setProvinceName(areasVo.getProvinceName());
//            guardian.setCityId(areasVo.getCityId());
//            guardian.setCityName(areasVo.getCityName());
//            guardian.setAreaName(areasVo.getAreaName());
            data.put("guardian", guardian);
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", 401);
            jsonObject.put("data", null);
        }
        return jsonObject;
    }

    @Override
    public JSONObject updateGuardian(Guardian guardian, String changeReason) {
        JSONObject jsonObject = new JSONObject();

        try {
            if (guardianMapper.updateGuardian(guardian) == 1) {
                ChangeLog changeLog = new ChangeLog();
                changeLog.setGuardianIdentity(guardian.getGuardianIdentity());
                changeLog.setChangeReasonContent(changeReason);
                if (changeLogMapper.insertUserChangeReason(changeLog) == 1) {
                    jsonObject.put("status", 200);
                }
            }else {
                jsonObject.put("status", 401);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("status", 401);
        }

        return jsonObject;
    }

    @Override
    public JSONObject getGuardianUserInfoDetail(String userIdentity) {

        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Guardian guardian = (Guardian) getGuardianInfo(userIdentity).getJSONObject("data").get("guardian");
        AreasVo areasVo = areasMapper.selectAreaVoByAreaId(guardian.getAreaId());
        if (guardian != null) {
            jsonObject.put("status", 200);
            guardian.setProvinceId(areasVo.getProvinceId());
            guardian.setProvinceName(areasVo.getProvinceName());
            guardian.setCityId(areasVo.getCityId());
            guardian.setCityName(areasVo.getCityName());
            guardian.setAreaName(areasVo.getAreaName());
            data.put("guardian", guardian);
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", 401);
            jsonObject.put("data", null);
        }
        return jsonObject;
    }
}
