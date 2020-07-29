package pl.mg.projects.players.controllers.playerControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.mg.projects.players.dto.Direction;
import pl.mg.projects.players.dto.PaginationDto;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.dto.SortField;
import pl.mg.projects.players.dto.exceptionsHandlerResponseDto.ErrorResponseDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;
import pl.mg.projects.players.services.playerServices.playerGET.PlayerService;
import pl.mg.projects.players.utils.ResponseMessagesBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/player")
public class PlayerControllerGET {

    private final PlayerService playerService;
    private final ResponseMessagesBuilder responseMessagesBuilder;

    @Autowired
    public PlayerControllerGET(PlayerService playerService, ResponseMessagesBuilder responseMessagesBuilder) {
        this.playerService = playerService;
        this.responseMessagesBuilder = responseMessagesBuilder;
    }

    @GetMapping
    public ResponseEntity<PaginationDto<PlayerDto>> getAllPlayers(@RequestParam(name = "perPage") Integer perPage,
                                                                  @RequestParam(name = "page") Integer page,
                                                                  @RequestParam(name = "sortBy") SortField sortField,
                                                                  @RequestParam(name = "teamName", required = false) String teamName,
                                                                  @RequestParam(name = "position", required = false) String position,
                                                                  @RequestParam(name = "playerName", required = false) String playerName,
                                                                  @RequestParam(name = "direction") Direction direction) {
        if (Objects.nonNull(playerName) && !playerName.trim().equals("")) {
            PaginationDto<PlayerDto> players = playerService.findByPlayerName(perPage, page, sortField, direction, playerName);
            if (players.getContent().isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            else return ResponseEntity.status(HttpStatus.OK).body(players);
        } else if (Objects.nonNull(position) && !position.trim().equals("")) {
            PaginationDto<PlayerDto> players = playerService.findByPosition(perPage, page, sortField, direction, position);
            if (players.getContent().isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            else return ResponseEntity.status(HttpStatus.OK).body(players);
        } else {
            PaginationDto<PlayerDto> players = playerService.findByTeamName(perPage, page, sortField, direction, teamName);
            if (players.getContent().isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            else return ResponseEntity.status(HttpStatus.OK).body(players);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getOnePlayer(@PathVariable Long id) throws PlayerNotFoundException {
        if (Objects.nonNull(id)) {
            PlayerDto chosenPlayer = playerService.getOnePlayer(id);
            return ResponseEntity.status(HttpStatus.OK).body(chosenPlayer);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception ex,
                                                                      WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        String message = responseMessagesBuilder.INTERNAL_SERVER_ERROR(ex, request);
        ErrorResponseDto error = new ErrorResponseDto(message, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}


