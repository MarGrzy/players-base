package pl.mg.projects.players.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mg.projects.players.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByUsername(String name);
}
