package com.stu.mapper;

import com.stu.entity.Areas;
import com.stu.vo.AreasVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreasMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Areas record);
//
//    int insertSelective(Areas record);
//
//    Areas selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Areas record);
//
//    int updateByPrimaryKey(Areas record);

    List<Areas> selectAreaByCityId(String cityId);
    AreasVo selectAreaVoByAreaId(String areaId);
}