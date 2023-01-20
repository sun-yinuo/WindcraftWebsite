package com.sunyinuo.opcrud.service.db.impl;

import com.sunyinuo.opcrud.mapper.TeamMemberMapper;
import com.sunyinuo.opcrud.model.TeamMember;
import com.sunyinuo.opcrud.service.db.TeamMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    @Resource
    private TeamMemberMapper teamMemberMapper;


    /**
     * 获取TeamMem列表
     * @return list
     */
    @Override
    public List<TeamMember> getTeamMemberList() {
        return teamMemberMapper.getTeamMemberList();
    }
}
