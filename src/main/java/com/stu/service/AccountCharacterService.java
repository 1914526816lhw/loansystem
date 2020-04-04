package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

/**
 * ClassName：AccountCharacterService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 11:47
 * @version 1.0.0
 */
@Repository
public interface AccountCharacterService {
    JSONObject getAllAccountCharacter();
}
