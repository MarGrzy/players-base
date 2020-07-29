package pl.mg.projects.players.services.playerServices.playerPOST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.PlayerRepository;
import pl.mg.projects.players.services.mappers.PlayerMapper;

@Service
public class PlayerServiceImplPOST implements PlayerServicePOST {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerServiceImplPOST(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

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
    public void createPlayer(PlayerDto newPlayerReceived) {
        Player newPlayer = playerMapper.toPlayer(newPlayerReceived);
        playerRepository.save(newPlayer);
    }
}
