package pl.mg.projects.players.services.playerServices.playerGET;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.mg.projects.players.dto.*;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {

    PlayerDto getOnePlayer(Long id) throws PlayerNotFoundException;

    List<String> getAllPlayers();

    List<PlayerDto> mapPlayerEntityToDto(Page<Player> allPlayers);

    List<String> getAllPlayersOfTeam(Team team);

    PaginationDto<PlayerDto> findAll(Example<Player> player, Integer perPage, Integer page, SortField sortField, Direction direction);

    PaginationDto<PlayerDto> findByPlayerName(Integer perPage, Integer page, SortField sortField, Direction direction, String playerName);

    PaginationDto<PlayerDto> findByTeamName(Integer perPage, Integer page, SortField sortField, Direction direction, String teamName);

    PaginationDto<PlayerDto> findByPosition(Integer perPage, Integer page, SortField sortField, Direction direction, String position);

    Pageable createPageRequest(Integer perPage, Integer page, SortField sortField, Direction direction);
}
