package pl.mg.projects.players.services.playerServices.playerPOST;

import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

public interface PlayerServicePOST {

    void addPlayer(Long id, String playerName, String position, Team team);

    Player createPlayer(PlayerDto newPlayerReceived);
}
