package pl.mg.projects.players.services.PlayerDELETE;

import pl.mg.projects.players.dto.PlayerDto;

public interface PlayerServiceDELETE {

    boolean delete(Long id, PlayerDto player);
}
