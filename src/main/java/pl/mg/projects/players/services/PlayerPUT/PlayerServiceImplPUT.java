package pl.mg.projects.players.services.PlayerPUT;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
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

        String newPlayerName = updatedPlayer.getPlayerName();
        String newPosition = updatedPlayer.getPosition();
        Team newTeam = updatedPlayer.getTeam();

        Optional<Player> playerToUpdate = playerRepository.findById(playerId);
        if (playerToUpdate.isEmpty()) {
            return false;
        } else {
            if (!playerToUpdate.get().getPlayerName().equals(newPlayerName)) {
                playerToUpdate.get().setPlayerName(newPlayerName);
            } else if (!playerToUpdate.get().getPosition().equals(newPosition)) {
                playerToUpdate.get().setPosition(newPosition);
            } else if (!playerToUpdate.get().getTeam().getTeamName().equals(newTeam.getTeamName())){
                playerToUpdate.get().setTeam(newTeam);
            }
            playerRepository.save(playerToUpdate.get());
        }
        return true;
    }
}
