package pl.mg.projects.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.mg.projects.players.dto.AuthorizationDto;

@EnableJpaRepositories("pl.mg.projects.players")
@EntityScan("pl.mg.projects.players.entities")
@SpringBootApplication
public class PlayersBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(PlayersBaseApp.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    } @Bean
    public AuthorizationDto authorizationDto(){
        return new AuthorizationDto();
    }
}
