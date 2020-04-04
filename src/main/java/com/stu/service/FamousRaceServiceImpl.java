package com.stu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stu.entity.FamousRace;
import com.stu.mapper.FamousRaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * ClassName：FamousRaceServiceImpl
 * Description：名族业务类
 *
 * @author lihw
 * CreateTime: 2020/4/1 11:19
 * @version 1.0.0
 */

@Service
public class FamousRaceServiceImpl implements FamousRaceService {

    @Autowired
    private FamousRaceMapper famousRaceMapper;

    @Override
    public JSONObject getAllFamousRace() {
        List<FamousRace> famousRaces = famousRaceMapper.selectAllFamousRace();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);

        jsonObject.put("data", famousRaces.toArray());

        return jsonObject;
    }
}
