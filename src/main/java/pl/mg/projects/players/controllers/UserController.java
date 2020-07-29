package pl.mg.projects.players.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mg.projects.players.dto.AuthorizationDto;
import pl.mg.projects.players.entities.User;
import pl.mg.projects.players.services.userServices.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody AuthorizationDto authorizationDto, HttpServletRequest request) {
        Optional<User> userByNewUsername = userService.getByUsername(authorizationDto.getUsername());
        if (userByNewUsername.isPresent()) return ResponseEntity.status(HttpStatus.IM_USED).build();
        if (this.userService.createUser(authorizationDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}