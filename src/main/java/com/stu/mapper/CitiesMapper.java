package com.stu.mapper;

import com.stu.entity.Cities;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Cities record);
//
//    int insertSelective(Cities record);
//
//    Cities selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Cities record);
//
//    int updateByPrimaryKey(Cities record);
    List<Cities> selectAllCityByProvinceId(String provinceId);
}