package pl.mg.projects.players.controllers.PlayerControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.repositories.PlayerRepository;
import pl.mg.projects.players.services.playerServices.playerPOST.PlayerServicePOST;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/player")
public class PlayerControllerPOST {

    private final PlayerRepository playerRepository;
    private final PlayerServicePOST playerServicePOST;

    @Autowired
    public PlayerControllerPOST(PlayerRepository playerRepository, PlayerServicePOST playerServicePOST) {
        this.playerRepository = playerRepository;
        this.playerServicePOST = playerServicePOST;
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createNewPlayer(@RequestBody @Valid PlayerDto newPlayer) {
        if (playerRepository.existsById(newPlayer.getId())) {
            newPlayer.setId(playerRepository.findTopByOrderByIdDesc().getId() + 1L);
        }
        playerServicePOST.createPlayer(newPlayer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
