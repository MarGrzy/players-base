package pl.mg.projects.players.services.teamServices;

import pl.mg.projects.players.dto.TeamDto;
import pl.mg.projects.players.entities.Team;

import java.util.List;


public interface TeamService {

    List<Team> getTeams();

    List<TeamDto> mapTeamEntityToDto(List<Team> allTeams);

    Team addTeam(String teamName);
}
