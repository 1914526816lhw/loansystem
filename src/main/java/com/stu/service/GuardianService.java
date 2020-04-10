package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.Guardian;
import org.springframework.stereotype.Repository;

/**
 * ClassName：GuardianService
 * Description：共同贷款人业务类
 *
 * @author lihw
 * CreateTime: 2020/4/4 15:14
 * @version 1.0.0
 */
@Repository
public interface GuardianService {
    JSONObject getGuardianByUserIdentity(String userIdentity);

    JSONObject getGuardianInfo(String userIdentity);

    JSONObject updateGuardian(Guardian guardian, String changeReason);
    JSONObject getGuardianUserInfoDetail(String userIdentity);
}
