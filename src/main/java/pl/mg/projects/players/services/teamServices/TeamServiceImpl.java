package pl.mg.projects.players.services.teamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.TeamDto;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.getAllBy();
    }

    @Override
    public List<TeamDto> mapTeamEntityToDto(List<Team> allTeams) {
        return allTeams
                .stream()
                .map(t -> new TeamDto(t.getId(), t.getTeamName()))
                .collect(Collectors.toList());
    }

    @Override
    public Team addTeam(String teamName) {

        Team newTeam = new Team();
        newTeam.setTeamName(teamName);
        teamRepository.save(newTeam);
        return newTeam;
    }
}
