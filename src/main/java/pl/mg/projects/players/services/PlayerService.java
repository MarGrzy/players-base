package pl.mg.projects.players.services;

import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

import java.util.List;

public interface PlayerService {
    public Player addPlayer(String name, String position, Team team);
    public List<String> getAllPlayers();
    public List<String> getAllPlayersOfTeam(Team team);
}
