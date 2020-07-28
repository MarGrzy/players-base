package pl.mg.projects.players.dto;

import org.springframework.transaction.annotation.Transactional;
import pl.mg.projects.players.entities.Team;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Transactional(readOnly = true)
public class PlayerDto {

    @Min(value = 1, message = "{PlayerDto.minValueId}")
    @NotNull(message = "{PlayerDto.notNull}")
    private Long id;

    @NotNull(message = "{PlayerDto.notNull}")
    private String playerName;

    @NotNull(message = "{PlayerDto.notNull}")
    private String position;

    @NotNull(message = "{PlayerDto.notNull}")
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
