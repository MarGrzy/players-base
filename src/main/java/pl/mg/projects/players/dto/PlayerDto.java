package pl.mg.projects.players.dto;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class PlayerDto {

    private Long id;

    private String playerName;

    private String position;

    public PlayerDto(Long id, String playerName, String position) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
