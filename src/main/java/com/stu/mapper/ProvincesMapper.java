package com.stu.mapper;

import com.stu.entity.Provinces;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvincesMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Provinces record);
//
//    int insertSelective(Provinces record);
//
//    Provinces selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Provinces record);
//
//    int updateByPrimaryKey(Provinces record);
    List<Provinces> selectAllProvince();
}