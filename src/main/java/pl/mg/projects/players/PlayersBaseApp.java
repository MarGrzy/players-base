package pl.mg.projects.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("pl.mg.projects.players")
@EntityScan("pl.mg.projects.players.entities")
@SpringBootApplication
public class PlayersBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(PlayersBaseApp.class, args);
    }
}
