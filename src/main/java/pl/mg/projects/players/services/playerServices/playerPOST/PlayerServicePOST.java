package pl.mg.projects.players.services.playerServices.playerPOST;

import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.services.exceptions.WrongNewPlayerDetailsException;

public interface PlayerServicePOST {

    void addPlayer(Long id, String playerName, String position, Team team);

    void createPlayer(PlayerDto newPlayerReceived) throws WrongNewPlayerDetailsException;
}
