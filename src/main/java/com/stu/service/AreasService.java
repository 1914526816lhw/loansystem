package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

/**
 * ClassName：AreasService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:57
 * @version 1.0.0
 */

@Repository
public interface AreasService {
    JSONObject getAllAreaByCityId(String cityId);
}
