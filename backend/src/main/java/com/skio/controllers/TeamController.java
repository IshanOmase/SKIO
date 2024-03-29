package com.skio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skio.services.ITeamService;
import com.skio.models.Team;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private ITeamService teamServ;

    public TeamController() {
        System.out.println("In team controller");
    }

    //get all teams
    @GetMapping
    public List<Team> listAllTeams(){
        return teamServ.getAllTeams();
    }

    //get team details by id
    @GetMapping("/{teamId")
    public Team getTeamDetails(@PathVariable Long teamId) {
        return teamServ.getById(teamId);
    }

    //add new Team
    @PostMapping
    public Team addTeamDetails(Team newTeam) {
        return teamServ.addTeamDetails(newTeam);
    }

    @PutMapping
    public Team updateTeamDetails(@RequestBody Team t) {
        return teamServ.updateTeamDetails(t);
    }

}
