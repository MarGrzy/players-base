package pl.mg.projects.players.services.PlayerPUT;

import pl.mg.projects.players.entities.Player;

public interface PlayerServicePUT {

    boolean updatePlayer(Long playerId, Player updatedPlayer);
}
