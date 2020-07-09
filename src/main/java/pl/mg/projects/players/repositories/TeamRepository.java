package pl.mg.projects.players.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mg.projects.players.entities.Team;

import java.util.List;


public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> getAllBy();

    Page<Team> getAllByTeamName(String teamName, Pageable pageable);
}
