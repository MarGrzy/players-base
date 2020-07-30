package pl.mg.projects.players.exampleMatchers;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.PlayerDto;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

@Service
public class PlayerExampleMatcher {

    public Example<PlayerDto> playerDtoExample(PlayerDto playerDto) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreNullValues()
                .withMatcher("playerName", startsWith().ignoreCase())
                .withMatcher("position", contains().ignoreCase())
                .withMatcher("team.teamName", contains().ignoreCase())
                .withIgnorePaths("id")
                .withIgnorePaths("team.id");
        return Example.of(playerDto, exampleMatcher);
    }
}
