package com.sunyinuo.opcrud.mapper;

import com.sunyinuo.opcrud.model.TeamMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyinuo
 */
@Mapper
public interface TeamMemberMapper {

    /**
     * 获取TeamMem列表
     * @return list
     */
    List<TeamMember> getTeamMemberList();

}
