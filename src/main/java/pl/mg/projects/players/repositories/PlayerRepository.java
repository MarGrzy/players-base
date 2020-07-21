package pl.mg.projects.players.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> getAllBy();

    Page<Player> findAllByPlayerNameStartsWith(String playerName, Pageable pageable);

    Page<Player> findAllByPosition(String position, Pageable pageable);

    List<Player> getAllByTeam(Team team);

    Page<Player> findAllByTeam_TeamNameStartsWith(String team_teamName, Pageable pageable);

    Page<Player> getAllByTeamAndPlayerNameStartsWith(Team team, String playerName, Pageable pageTeam);

    Page<Player> getAllByTeamAndPosition(Team team, String position, Pageable pageTeam);
}
