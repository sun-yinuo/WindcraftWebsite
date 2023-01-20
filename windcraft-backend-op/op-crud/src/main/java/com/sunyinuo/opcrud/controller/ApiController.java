package com.sunyinuo.opcrud.controller;

import com.sunyinuo.opcrud.model.TeamMember;
import com.sunyinuo.opcrud.service.db.impl.TeamMemberServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/opcrud/api")
public class ApiController {

    private final TeamMemberServiceImpl teamMemberService;

    public ApiController(TeamMemberServiceImpl teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GetMapping("/getTeamMemberList")
    public List<TeamMember> getTeamMemberList(){
        return teamMemberService.getTeamMemberList();
    }

}
