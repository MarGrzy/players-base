package pl.mg.projects.players.services;

import pl.mg.projects.players.entities.Team;

import java.util.List;

public interface PlayerService {
    void addPlayer(Long id, String name, String position, Team team);
    List<String> getAllPlayers();
    List<String> getAllPlayersOfTeam(Team team);
}
