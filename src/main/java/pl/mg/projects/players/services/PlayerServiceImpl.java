package pl.mg.projects.players.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void addPlayer(Long id, String name, String position, Team team) {

        Player newPlayer = new Player();
        newPlayer.setId(id);
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setTeam(team);
        playerRepository.save(newPlayer);
    }

    @Override
    public List<String> getAllPlayers() {
        List<String> allPlayersNames = new ArrayList<String>();
        List<Player> allPlayers = playerRepository.getAllBy();
        for (Player player : allPlayers) {
            allPlayersNames.add(player.getName());
        }
        return allPlayersNames;
    }

    @Override
    public List<String> getAllPlayersOfTeam(Team team) {
        List<String> allPlayersOfTeamNames = new ArrayList<String>();
        List<Player> allPlayers = playerRepository.getAllByTeam(team);
        for (Player player : allPlayers) {
            allPlayersOfTeamNames.add(player.getName());
        }
        return allPlayersOfTeamNames;
    }
}
