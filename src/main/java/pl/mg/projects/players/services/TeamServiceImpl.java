package pl.mg.projects.players.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team addTeam(String teamName) {

        Team newTeam = new Team();
        newTeam.setTeamName(teamName);
        teamRepository.save(newTeam);
        return newTeam;
    }
}
