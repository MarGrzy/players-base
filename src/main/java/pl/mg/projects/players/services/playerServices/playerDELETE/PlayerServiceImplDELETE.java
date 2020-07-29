package pl.mg.projects.players.services.playerServices.playerDELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.repositories.PlayerRepository;

@Service
public class PlayerServiceImplDELETE implements PlayerServiceDELETE {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImplDELETE(PlayerRepository playerRepository) { this.playerRepository = playerRepository; }

    @Override
    public boolean delete(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        }
        else return false;
    }
}
