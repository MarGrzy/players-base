package pl.mg.projects.players.services.playerServices.playerPUT;

import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;

public interface PlayerServicePUT {

    void updatePlayer(Long playerId, PlayerDto updatedPlayer) throws PlayerNotFoundException;
}
