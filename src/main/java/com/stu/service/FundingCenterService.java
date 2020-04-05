package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

/**
 * ClassName：FundingCenterService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/5 10:19
 * @version 1.0.0
 */
@Repository
public interface FundingCenterService {
    JSONObject getAllFundingCenter();
}
