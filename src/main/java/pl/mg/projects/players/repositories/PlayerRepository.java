package pl.mg.projects.players.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import pl.mg.projects.players.entities.Player;
import pl.mg.projects.players.entities.Team;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long>, QueryByExampleExecutor<Player> {

    List<Player> getAllBy();

    Optional<Player> getByPlayerName(String playerName);

    Page<Player> findAll(Pageable pageable);

    List<Player> getAllByTeam(Team team);

    Player findTopByOrderByIdDesc();
}
