package pl.mg.projects.players.services.PlayerPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.PlayerRepository;

@Service
public class PlayerServiceImplPOST implements PlayerServicePOST {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplPOST(PlayerRepository playerRepository) { this.playerRepository = playerRepository; }

    @Override
    public void addPlayer(Long id, String playerName, String position, Team team) {

        Player newPlayer = new Player();
        newPlayer.setId(id);
        newPlayer.setPlayerName(playerName);
        newPlayer.setPosition(position);
        newPlayer.setTeam(team);
        playerRepository.save(newPlayer);
    }

    @Override
    public void createPlayer(Player newPlayer) {
        playerRepository.save(newPlayer);
    }
}
