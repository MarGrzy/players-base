package pl.mg.projects.players.dto;

public class AuthorizationDto {
    private String userName;
    private String password;

    public AuthorizationDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
