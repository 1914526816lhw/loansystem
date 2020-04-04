package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

/**
 * ClassName：CitiesService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:36
 * @version 1.0.0
 */
@Repository
public interface CitiesService {
    JSONObject getAllCityByProvinceId(String provinceId);
}
