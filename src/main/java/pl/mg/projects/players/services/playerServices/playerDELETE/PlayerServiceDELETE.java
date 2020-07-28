package pl.mg.projects.players.services.playerServices.playerDELETE;

import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;

public interface PlayerServiceDELETE {

    boolean delete(Long id, PlayerDto player) throws PlayerNotFoundException;
}
