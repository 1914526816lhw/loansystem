package com.stu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stu.entity.Provinces;
import com.stu.mapper.ProvincesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName：ProvinceServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:19
 * @version 1.0.0
 */
@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;

    @Override
    public JSONObject getAllProvince() {
        JSONObject jsonObject = new JSONObject();
        JSONObject provinceJson = new JSONObject();
        JSONArray data = new JSONArray();
        List<Provinces> provincesList = provincesMapper.selectAllProvince();

        for(Provinces province:provincesList){
            provinceJson.put("provinceId",province.getProvinceId());
            provinceJson.put("provinceName",province.getProvinceName());
            data.add(JSON.parseObject(provinceJson.toJSONString()));
            provinceJson.clear();
        }

        jsonObject.put("status",200);

        jsonObject.put("data",data);
        return jsonObject;
    }
}
