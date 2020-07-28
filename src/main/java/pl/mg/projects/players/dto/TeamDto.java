package pl.mg.projects.players.dto;


import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Transactional(readOnly = true)
public class TeamDto {

    @Min(value = 1, message = "{TeamDto.minValueId}")
    @NotNull(message = "{TeamDto.notNull}")
    private Long id;

    @NotNull(message = "{TeamDto.notNull}")
    private String teamName;

    public TeamDto(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
