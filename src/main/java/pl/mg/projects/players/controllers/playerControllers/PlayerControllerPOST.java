package pl.mg.projects.players.controllers.playerControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.dto.exceptionsHandlerResponseDto.ErrorResponseDto;
import pl.mg.projects.players.repositories.PlayerRepository;
import pl.mg.projects.players.services.exceptions.WrongNewPlayerDetailsException;
import pl.mg.projects.players.services.playerServices.playerPOST.PlayerServicePOST;
import pl.mg.projects.players.utils.ResponseMessagesBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/player")
public class PlayerControllerPOST {

    private final PlayerRepository playerRepository;
    private final PlayerServicePOST playerServicePOST;
    private final ResponseMessagesBuilder responseMessagesBuilder;

    @Autowired
    public PlayerControllerPOST(PlayerRepository playerRepository, PlayerServicePOST playerServicePOST, ResponseMessagesBuilder responseMessagesBuilder) {
        this.playerRepository = playerRepository;
        this.playerServicePOST = playerServicePOST;
        this.responseMessagesBuilder = responseMessagesBuilder;
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createNewPlayer(@Valid @RequestBody PlayerDto newPlayer) throws WrongNewPlayerDetailsException {
        if (playerRepository.existsById(newPlayer.getId())) {
            newPlayer.setId(playerRepository.findTopByOrderByIdDesc().getId() + 1L);
        }
        playerServicePOST.createPlayer(newPlayer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
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
