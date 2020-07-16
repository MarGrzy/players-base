package pl.mg.projects.players.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.mg.projects.players.dto.*;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

import java.util.List;

public interface PlayerService {
    void addPlayer(Long id, String name, String position, Team team);
    List<String> getAllPlayers();

    List<PlayerDto> mapPlayerEntityToDto(Page<Player> allPlayers);

    List<String> getAllPlayersOfTeam(Team team);

    PaginationDto<PlayerDto> findByName(Integer perPage, Integer page, SortField sortField, Direction direction, String playerName);

    PaginationDto<PlayerDto> findByTeam(Integer perPage, Integer page, SortField sortField, Direction direction, Team team);

    PaginationDto<PlayerDto> findByPosition(Integer perPage, Integer page, SortField sortField, Direction direction, String playerPosition);

    Pageable createPageRequest(Integer perPage, Integer page, SortField sortField, Direction direction);
}
