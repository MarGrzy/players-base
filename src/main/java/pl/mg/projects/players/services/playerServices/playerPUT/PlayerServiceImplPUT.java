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

        Optional<Player> playerToUpdate = playerRepository.findById(playerId);

        String newPlayerName = updatedPlayer.getPlayerName();
        String newPosition = updatedPlayer.getPosition();
        Team newTeam = updatedPlayer.getTeam();


        if (playerToUpdate.isEmpty()) {
            throw new PlayerNotFoundException("Player not found in database!");
        } else {
            if (newPlayerName == null) {
                newPlayerName = playerToUpdate.get().getPlayerName();
            } do { playerToUpdate.get().setPlayerName(newPlayerName); }
            while ((!playerToUpdate.get().getPlayerName().equals(newPlayerName)));

            if (newPosition == null) {
                newPosition = playerToUpdate.get().getPosition();
            } do { playerToUpdate.get().setPosition(newPosition); }
            while (!playerToUpdate.get().getPosition().equals(newPosition));

            if (newTeam == null) {
                newTeam = playerToUpdate.get().getTeam();
            } do { playerToUpdate.get().setTeam(newTeam); }
            while (!playerToUpdate.get().getTeam().getTeamName().equals((newTeam).getTeamName()));
        }
        playerRepository.save(playerToUpdate.get());
    }
}
