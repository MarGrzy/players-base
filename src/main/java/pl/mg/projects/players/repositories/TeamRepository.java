package pl.mg.projects.players.repositories;

import org.springframework.data.domain.Page;
import pl.mg.projects.players.entities.Team;

import java.awt.print.Pageable;

public interface TeamRepository {

    Page<Team> getAllBy(Pageable pageable);

    Page<Team> getAllByTeamName(Pageable pageable, String teamName);
}
