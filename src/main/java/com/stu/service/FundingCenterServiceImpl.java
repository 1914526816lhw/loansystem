package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.FundingCenter;
import com.stu.entity.Users;
import com.stu.mapper.FundingCenterMapper;
import com.stu.mapper.UsersMapper;
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
public class FundingCenterServiceImpl implements FundingCenterService {

    @Autowired
    private FundingCenterMapper fundingCenterMapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public JSONObject getAllFundingCenter() {
        JSONObject jsonObject = new JSONObject();
        List<FundingCenter> centerList = fundingCenterMapper.selectAllFundingCenter();
        jsonObject.put("status", 200);
        jsonObject.put("data", centerList);

        return jsonObject;
    }

    @Override
    public JSONObject getFundingCenter(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if (users != null) {
            FundingCenter fundingCenter = fundingCenterMapper.selectFundingCenterByCenterId(users.getFundingCenterId());
            if (fundingCenter != null) {
                jsonObject.put("status",200);
                data.put("fundingCenter",fundingCenter);
                jsonObject.put("data",data);
            }else {
                jsonObject.put("status",401);
                jsonObject.put("data",null);
            }
        }else {
            jsonObject.put("status",401);
            jsonObject.put("data",null);
        }
        return jsonObject;
    }
}
