package pl.mg.projects.players.dto;

import org.springframework.transaction.annotation.Transactional;
import pl.mg.projects.players.entities.Team;

@Transactional(readOnly = true)
public class PlayerDto {

    private Long id;

    private String playerName;

    private String position;

    private Team team;

    public PlayerDto(Long id, String playerName, String position, Team team) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.team = team;
    }

    public PlayerDto() {}

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

    public String getPosition() { return position; }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }
}
