package pl.mg.projects.players.controllers.PlayerControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;
import pl.mg.projects.players.services.playerServices.playerDELETE.PlayerServiceDELETE;

import java.util.Objects;

@RestController
@RequestMapping(path = "/player")
public class PlayerControllerDELETE {

    private final PlayerServiceDELETE playerServiceDELETE;

    @Autowired
    public PlayerControllerDELETE(PlayerServiceDELETE playerServiceDELETE) {
        this.playerServiceDELETE = playerServiceDELETE;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerDto> deletePlayer(@PathVariable Long id) throws PlayerNotFoundException {
        if (Objects.nonNull(id)) {
            if (playerServiceDELETE.delete(id)) return ResponseEntity.status(HttpStatus.OK).build();
            else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
