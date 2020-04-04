package com.stu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stu.entity.Cities;
import com.stu.mapper.CitiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName：CitiesServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:38
 * @version 1.0.0
 */
@Service
public class CitiesServiceImpl implements CitiesService{

    @Autowired
    private CitiesMapper citiesMapper;

    @Override
    public JSONObject getAllCityByProvinceId(String provinceId) {

        JSONObject jsonObject = new JSONObject();
        JSONObject cityJson = new JSONObject();
        JSONArray data = new JSONArray();
        List<Cities> citiesList = citiesMapper.selectAllCityByProvinceId(provinceId);
        for (Cities city:citiesList){
            cityJson.put("cityId",city.getCityId());
            cityJson.put("cityName",city.getCityName());
            data.add(JSON.parseObject(cityJson.toJSONString()));
            cityJson.clear();
        }
        jsonObject.put("status",200);
        jsonObject.put("data",data.toArray());
        data.clear();
        return jsonObject;
    }
}
