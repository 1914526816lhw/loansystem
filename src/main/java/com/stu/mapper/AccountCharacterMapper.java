package com.stu.mapper;

import com.stu.entity.AccountCharacter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountCharacterMapper {
//    int deleteByPrimaryKey(Integer accountCharacterId);
//
//    int insert(AccountCharacter record);
//
//    int insertSelective(AccountCharacter record);
//
//    AccountCharacter selectByPrimaryKey(Integer accountCharacterId);
//
//    int updateByPrimaryKeySelective(AccountCharacter record);
//
//    int updateByPrimaryKey(AccountCharacter record);
    List<AccountCharacter> selectAllAccountCharacter();
}