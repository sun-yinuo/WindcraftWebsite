package com.sunyinuo.opcrud.service.db;

import com.sunyinuo.opcrud.model.TeamMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyinuo
 */
@Mapper
public interface TeamMemberService {

    /**
     * 获取TeamMem列表
     * @return list
     */
    List<TeamMember> getTeamMemberList();
}
