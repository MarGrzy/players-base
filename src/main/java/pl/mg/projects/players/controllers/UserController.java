package pl.mg.projects.players.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.mg.projects.players.dto.AuthorizationDto;
import pl.mg.projects.players.dto.UserTransfer;
import pl.mg.projects.players.dto.exceptionsHandlerResponseDto.ErrorResponseDto;
import pl.mg.projects.players.entities.User;
import pl.mg.projects.players.security.TokenUtil;
import pl.mg.projects.players.services.userServices.UserService;
import pl.mg.projects.players.utils.ResponseMessagesBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/user/")
public class UserController {

    private final UserService userService;
    private final ResponseMessagesBuilder responseMessagesBuilder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService, ResponseMessagesBuilder responseMessagesBuilder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.responseMessagesBuilder = responseMessagesBuilder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody AuthorizationDto authorizationDto) {
        Optional<User> userByNewUsername = userService.getByUsername(authorizationDto.getUsername());
        if (userByNewUsername.isPresent()) return ResponseEntity.status(HttpStatus.IM_USED).build();
        if (this.userService.createUser(authorizationDto)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserTransfer> login(@RequestBody AuthorizationDto authorizationDto) {
        String username = authorizationDto.getUsername();
        String password = authorizationDto.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = this.userService.loadUserByUsername(username);

        Optional<? extends GrantedAuthority> roleOptional = userDetails.getAuthorities().stream().findAny();
        String role = roleOptional.map(Object::toString).orElse("");

        return ResponseEntity.status(HttpStatus.OK).body(new UserTransfer(userDetails.getUsername(), role,
                TokenUtil.createToken(userDetails), HttpStatus.OK));
//        Optional<User> userByUsername = userService.getByUsername(authorizationDto.getUsername());
//        if (userByUsername.isPresent()) {
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }
//    else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
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