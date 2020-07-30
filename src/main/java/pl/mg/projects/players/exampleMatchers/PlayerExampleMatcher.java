package pl.mg.projects.players.exampleMatchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.PlayerDto;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.services.mappers.PlayerMapper;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

@Service
public class PlayerExampleMatcher {

    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerExampleMatcher(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    public Example<PlayerDto> playerDtoExample(PlayerDto playerDto) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreNullValues()
                .withMatcher("playerName", startsWith().ignoreCase())
                .withMatcher("position", contains().ignoreCase())
                .withMatcher("team.teamName", contains().ignoreCase())
                .withIgnorePaths("id")
                .withIgnorePaths("team.id");
        return Example.of(playerDto, exampleMatcher);
    }

    public Example<Player> mapExamplePlayerDtoToExamplePlayer(Example<PlayerDto> playerDtoExample) {
        Player player = playerMapper.toPlayer(playerDtoExample.getProbe());
        return Example.of(player, playerDtoExample.getMatcher());
    }
}
