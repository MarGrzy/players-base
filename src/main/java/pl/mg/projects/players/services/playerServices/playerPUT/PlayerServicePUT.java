package pl.mg.projects.players.services.playerServices.playerPUT;

import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;

public interface PlayerServicePUT {

    boolean updatePlayer(Long playerId, Player updatedPlayer) throws PlayerNotFoundException;
}
