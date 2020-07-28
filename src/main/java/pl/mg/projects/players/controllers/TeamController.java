package pl.mg.projects.players.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mg.projects.players.dto.TeamDto;
import pl.mg.projects.players.services.teamServices.TeamService;

import java.util.List;

@RestController
@RequestMapping(path = "/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        List<TeamDto> teams = teamService.mapTeamEntityToDto(teamService.getTeams());
        return ResponseEntity.status(HttpStatus.OK).body(teams);
    }
}
