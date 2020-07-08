package pl.mg.projects.players.dto;

public class AuthorizationDto {
    private String username;
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
