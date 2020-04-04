package com.stu.mapper;

import com.stu.entity.FamousRace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamousRaceMapper {
//    int deleteByPrimaryKey(Integer famousRaceId);
//
//    int insert(FamousRace record);
//
//    int insertSelective(FamousRace record);
//
//    FamousRace selectByPrimaryKey(Integer famousRaceId);
//
//    int updateByPrimaryKeySelective(FamousRace record);
//
//    int updateByPrimaryKey(FamousRace record);

    List<FamousRace> selectAllFamousRace();
}