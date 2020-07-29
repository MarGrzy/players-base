package pl.mg.projects.players.services.playerServices.playerPUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.PlayerRepository;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;

import java.util.Optional;

@Service
public class PlayerServiceImplPUT implements PlayerServicePUT {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplPUT(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void updatePlayer(Long playerId, PlayerDto updatedPlayer) throws PlayerNotFoundException {

        Optional<Player> optionalPlayerToUpdate = playerRepository.findById(playerId);
        Player playerToUpdate;

        String newPlayerName = updatedPlayer.getPlayerName();
        String newPosition = updatedPlayer.getPosition();
        Team newTeam = updatedPlayer.getTeam();

        if (optionalPlayerToUpdate.isEmpty()) {
            throw new PlayerNotFoundException("Player not found in database!");
        } else {
            playerToUpdate = optionalPlayerToUpdate.get();

            if (newPlayerName == null || newPlayerName.trim().equals("")) {
                newPlayerName = playerToUpdate.getPlayerName();
            } do { playerToUpdate.setPlayerName(newPlayerName); }
            while ((!playerToUpdate.getPlayerName().equals(newPlayerName)));

            if (newPosition == null || newPosition.trim().equals("")) {
                newPosition = playerToUpdate.getPosition();
            } do { playerToUpdate.setPosition(newPosition); }
            while (!playerToUpdate.getPosition().equals(newPosition));

            if (newTeam == null) {
                newTeam = playerToUpdate.getTeam();
            } do { playerToUpdate.setTeam(newTeam); }
            while (!playerToUpdate.getTeam().getTeamName().equals((newTeam).getTeamName()));
        }
        playerRepository.save(playerToUpdate);
    }
}
