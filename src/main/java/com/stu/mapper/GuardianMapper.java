package com.stu.mapper;

import com.stu.entity.Guardian;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianMapper {
    Guardian selectByUserIdentity(String userIdentity);
    int insert(Guardian guardian) throws Exception;
    int updateGuardian(Guardian guardian) throws Exception;
}