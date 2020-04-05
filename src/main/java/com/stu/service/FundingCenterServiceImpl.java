package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.FundingCenter;
import com.stu.mapper.FundingCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName：FundingCenterServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/5 10:20
 * @version 1.0.0
 */
@Service
public class FundingCenterServiceImpl implements FundingCenterService{

    @Autowired
    private FundingCenterMapper fundingCenterMapper;

    @Override
    public JSONObject getAllFundingCenter() {
        JSONObject jsonObject = new JSONObject();
        List<FundingCenter> centerList = fundingCenterMapper.selectAllFundingCenter();
        jsonObject.put("status",200);
        jsonObject.put("data",centerList);

        return jsonObject;
    }
}
