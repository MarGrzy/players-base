package pl.mg.projects.players.controllers.playerControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.dto.exceptionsHandlerResponseDto.ErrorResponseDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;
import pl.mg.projects.players.services.playerServices.playerPUT.PlayerServicePUT;
import pl.mg.projects.players.utils.ResponseMessagesBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/player")
public class PlayerControllerPUT {

    private final PlayerServicePUT playerServicePUT;
    private final ResponseMessagesBuilder responseMessagesBuilder;

    @Autowired
    public PlayerControllerPUT(PlayerServicePUT playerServicePUT, ResponseMessagesBuilder responseMessagesBuilder) {
        this.playerServicePUT = playerServicePUT;
        this.responseMessagesBuilder = responseMessagesBuilder;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto updatedPlayer) throws PlayerNotFoundException {
        if (Objects.nonNull(id)) {
            playerServicePUT.updatePlayer(id, updatedPlayer);
            return ResponseEntity.status(HttpStatus.OK).build();
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
