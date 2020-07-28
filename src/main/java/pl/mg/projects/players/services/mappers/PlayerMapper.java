package pl.mg.projects.players.services.mappers;

import org.mapstruct.Mapper;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.entities.Player;

@Mapper
public interface PlayerMapper {

    PlayerDto toPlayerDTO(Player player);

    Player toPlayer(PlayerDto playerDto);
}
