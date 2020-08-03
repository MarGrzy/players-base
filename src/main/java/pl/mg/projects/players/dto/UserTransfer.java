package pl.mg.projects.players.dto;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;

import java.util.Optional;

public class UserTransfer {

    private final String username;
    private final String role;
    private final String token;
    private final HttpStatus status;

    public UserTransfer(String username, String role, String token, HttpStatus status) {
        this.role = role;
        this.token = token;
        this.username = username;
        this.status = status;
    }

    public UserTransfer() {
        this.token = "";
        this.username = "";
        this.role = "";
        this.status = HttpStatus.NOT_FOUND;
    }

    public String getRole() {
        return this.role;
    }

    public String getToken() {
        return this.token;
    }

    public String getUsername() {
        return this.username;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
