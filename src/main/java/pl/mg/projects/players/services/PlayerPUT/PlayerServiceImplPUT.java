package pl.mg.projects.players.services.PlayerPUT;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.repositories.PlayerRepository;

import java.util.Optional;

public class PlayerServiceImplPUT implements PlayerServicePUT {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplPUT(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public boolean updatePlayer(Long playerId, Player updatedPlayer) {
        Optional<Player> playerToUpdate = playerRepository.findById(playerId);
        if (playerToUpdate.isEmpty()) {
            return false;
        }
        else
            playerToUpdate.get().setPlayerName(updatedPlayer.getPlayerName());
            playerToUpdate.get().setPosition(updatedPlayer.getPosition());
            playerToUpdate.get().setTeam(updatedPlayer.getTeam());
            playerRepository.save(playerToUpdate.get());
        return true;
    }
}
