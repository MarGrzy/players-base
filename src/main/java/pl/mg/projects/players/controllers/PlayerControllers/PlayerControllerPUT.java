package pl.mg.projects.players.controllers.PlayerControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;
import pl.mg.projects.players.services.playerServices.playerPUT.PlayerServicePUT;

import java.util.Objects;

@RestController
@RequestMapping(path = "/player")
public class PlayerControllerPUT {

    private final PlayerServicePUT playerServicePUT;

    @Autowired
    public PlayerControllerPUT(PlayerServicePUT playerServicePUT) {
        this.playerServicePUT = playerServicePUT;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto updatedPlayer) throws PlayerNotFoundException {
        if (Objects.nonNull(id)) {
            playerServicePUT.updatePlayer(id, updatedPlayer);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
