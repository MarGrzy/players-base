package pl.mg.projects.players.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mg.projects.players.dto.TeamDto;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> getAllBy();

    Page<Player> getAllBy(Pageable pageable);

    Page<Player> getAllByPlayerNameStartsWith(Pageable pageable, String playerName);

    Page<Player> getAllByPosition(Pageable pageable, String position);

    List<Player> getAllByTeam(Team team);

    Page<Player> getAllByTeamOrderByTeam(Team team, Pageable pageTeam);

    Page<Player> getAllByTeamAndPlayerNameStartsWith(Team team, String playerName, Pageable pageTeam);

    Page<Player> getAllByTeamAndPosition(Team team, String position, Pageable pageTeam);
}
