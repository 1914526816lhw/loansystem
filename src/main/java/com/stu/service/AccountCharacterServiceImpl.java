package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.AccountCharacter;
import com.stu.mapper.AccountCharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName：AccountCharacterServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 11:48
 * @version 1.0.0
 */
@Service
public class AccountCharacterServiceImpl implements AccountCharacterService{

    @Autowired
    private AccountCharacterMapper accountCharacterMapper;

    @Override
    public JSONObject getAllAccountCharacter() {

        JSONObject jsonObject = new JSONObject();
        List<AccountCharacter> characterList = accountCharacterMapper.selectAllAccountCharacter();
        jsonObject.put("status",200);
        jsonObject.put("data",characterList);
        return jsonObject;
    }
}
