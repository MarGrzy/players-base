package pl.mg.projects.players.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AuthorizationDto {

    @NotNull(message = "{AuthorizationDto.username.notNull}")
    @Size(min = 3, max = 20, message = "{AuthorizationDto.username.size}")
    @Pattern(regexp = "(^[A-Z][a-z]*)", message = "{AuthorizationDto.username.pattern}")
    private String username;

    @NotNull(message = "{AuthorizationDto.password.notNull}")
    @Size(min = 5, max = 20, message = "{AuthorizationDto.password.size}")
    @Pattern(regexp = "(?=.*\\d)", message = "{AuthorizationDto.password.pattern}")
    private String password;

    public AuthorizationDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
