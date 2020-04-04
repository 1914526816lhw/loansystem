package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.FamousRace;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName：FamousRaceService
 * Description：名族业务接口
 *
 * @author lihw
 * CreateTime: 2020/4/1 11:17
 * @version 1.0.0
 */
@Repository
public interface FamousRaceService {
    JSONObject getAllFamousRace();

}
