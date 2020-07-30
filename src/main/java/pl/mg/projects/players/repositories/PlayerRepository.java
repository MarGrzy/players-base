package pl.mg.projects.players.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long>, QueryByExampleExecutor<Player> {

    List<Player> getAllBy();

    Page<Player> findAll(Pageable pageable);

    Page<Player> findAllByPlayerNameStartsWith(String playerName, Pageable pageable);

    Page<Player> findAllByPosition(String position, Pageable pageable);

    List<Player> getAllByTeam(Team team);

    Page<Player> findAllByTeam_TeamName(String team_teamName, Pageable pageable);

    Page<Player> findAllByTeam_TeamNameAndPlayerNameStartsWith(String team_teamName, String playerName, Pageable pageTeam);

    Page<Player> findAllByTeam_TeamNameAndPosition(String team_teamName, String position, Pageable pageTeam);

    Player findTopByOrderByIdDesc();
}
