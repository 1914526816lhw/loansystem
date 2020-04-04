package com.stu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stu.entity.Areas;
import com.stu.mapper.AreasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName：AreasServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:57
 * @version 1.0.0
 */
@Service
public class AreasServiceImpl implements AreasService {
    
    @Autowired
    private AreasMapper areasMapper;

    @Override
    public JSONObject getAllAreaByCityId(String cityId) {
        JSONObject jsonObject = new JSONObject();
        JSONObject areaJson = new JSONObject();
        JSONArray data = new JSONArray();
        List<Areas> citiesList = areasMapper.selectAreaByCityId(cityId);
        for (Areas area:citiesList){
            areaJson.put("cityId",area.getAreaId());
            areaJson.put("cityName",area.getAreaName());
            data.add(JSON.parseObject(areaJson.toJSONString()));
            areaJson.clear();
        }
        jsonObject.put("status",200);
        jsonObject.put("data",data.toArray());
        data.clear();
        return jsonObject;
    }
}
