package pl.mg.projects.players.services.playerServices.playerGET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.Direction;
import pl.mg.projects.players.dto.PaginationDto;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.dto.SortField;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.PlayerRepository;
import pl.mg.projects.players.services.mappers.PlayerMapper;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }


    @Override
    public PlayerDto getOnePlayer(Long id) throws PlayerNotFoundException {
        Optional<Player> chosenPlayer = playerRepository.findById(id);
        if (chosenPlayer.isPresent()) {
            return playerMapper.toPlayerDTO(chosenPlayer.get());
        } else throw new PlayerNotFoundException("Player not found in database!");
    }

    @Override
    public List<String> getAllPlayers() {
        List<String> allPlayersNames = new ArrayList<String>();
        List<Player> allPlayers = playerRepository.getAllBy();
        for (Player player : allPlayers) {
            allPlayersNames.add(player.getPlayerName());
        }
        return allPlayersNames;
    }

    @Override
    public List<PlayerDto> mapPlayerEntityToDto(Page<Player> allPlayers) {
        return allPlayers.getContent()
                .stream()
                .map(p -> new PlayerDto(p.getId(), p.getPlayerName(), p.getPosition(), p.getTeam()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllPlayersOfTeam(Team team) {
        List<String> allPlayersOfTeamNames = new ArrayList<String>();
        List<Player> allPlayers = playerRepository.getAllByTeam(team);
        for (Player player : allPlayers) {
            allPlayersOfTeamNames.add(player.getPlayerName());
        }
        return allPlayersOfTeamNames;
    }

    @Override
    public PaginationDto<PlayerDto> findByPlayerName(Integer perPage, Integer page, SortField sortField, Direction direction, String playerName) {
        Pageable pageRequest = createPageRequest(perPage, page, sortField, direction);
        List<PlayerDto> responseDtoList = mapPlayerEntityToDto(playerRepository.findAllByPlayerNameStartsWith(playerName, pageRequest));
        return new PaginationDto<>(responseDtoList, (long) responseDtoList.size());
    }

    @Override
    public PaginationDto<PlayerDto> findByTeamName(Integer perPage, Integer page, SortField sortField, Direction direction, String teamName) {
        Pageable pageRequest = createPageRequest(perPage, page, sortField, direction);
        List<PlayerDto> responseDtoList = mapPlayerEntityToDto(playerRepository.findAllByTeam_TeamNameStartsWith(teamName, pageRequest));
        return new PaginationDto<>(responseDtoList, (long) responseDtoList.size());
    }

    @Override
    public PaginationDto<PlayerDto> findByPosition(Integer perPage, Integer page, SortField sortField, Direction direction, String position) {
        Pageable pageRequest = createPageRequest(perPage, page, sortField, direction);
        List<PlayerDto> responseDtoList = mapPlayerEntityToDto(playerRepository.findAllByPosition(position, pageRequest));
        return new PaginationDto<>(responseDtoList, (long) responseDtoList.size());
    }

    @Override
    public Pageable createPageRequest(Integer perPage, Integer page, SortField sortField, Direction direction) {
        PageRequest pageRequest;
        Sort.Direction sortDirection;
        if (direction.equals(Direction.asc)) {
            sortDirection = Sort.Direction.ASC;
        } else {
            sortDirection = Sort.Direction.DESC;
        }
        if (sortField.equals(SortField.playerName)) {
            pageRequest = PageRequest.of(page, perPage, sortDirection, "playerName");
        } else if (sortField.equals(SortField.position)) {
            pageRequest = PageRequest.of(page, perPage, sortDirection, "position");
        } else {
            pageRequest = PageRequest.of(page, perPage, sortDirection, "team.teamName");
        }
        return pageRequest;
    }
}
