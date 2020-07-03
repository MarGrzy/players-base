package pl.mg.projects.players.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mg.projects.players.dto.AuthorizationDto;
import pl.mg.projects.players.entities.Team;
import pl.mg.projects.players.repositories.TeamRepository;
import pl.mg.projects.players.services.PlayerService;
import pl.mg.projects.players.services.TeamService;
import pl.mg.projects.players.services.UserService;

import java.util.List;

@Component
public class Startup implements CommandLineRunner {

    private final UserService userService;
    private final TeamService teamService;
    private final PlayerService playerService;
    private final AuthorizationDto authorizationDto;

    private final TeamRepository teamRepository;

    @Autowired
    public Startup(UserService userService, TeamService teamService, PlayerService playerService, AuthorizationDto authorizationDto, TeamRepository teamRepository) {
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.authorizationDto = authorizationDto;
        this.teamRepository = teamRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        authorizationDto.setUserName("Dave");
        authorizationDto.setPassword("dave");
        userService.createUser(authorizationDto);

        Team boston = teamRepository.getOne(2l);

        playerService.addPlayer(5l,"Jayson Tatum", "SF / PF", boston);

        List<String> allPlayers = playerService.getAllPlayers();
        for (String player : allPlayers) {
            System.out.println("All players in database " + player);
        }

        List<String> allPlayersOfTeam = playerService.getAllPlayersOfTeam(boston);
        for (String player : allPlayersOfTeam) {
            System.out.println("All Boston Celtics players in database " + player);
        }
    }
}