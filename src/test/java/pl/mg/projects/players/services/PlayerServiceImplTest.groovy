package pl.mg.projects.players.services


import org.springframework.beans.factory.annotation.Autowired
import pl.mg.projects.players.entities.Team
import pl.mg.projects.players.repositories.PlayerRepository
import pl.mg.projects.players.services.PlayerGET.PlayerService
import pl.mg.projects.players.services.PlayerGET.PlayerServiceImpl
import spock.lang.Specification

class PlayerServiceImplTest extends Specification {

    @Autowired
    private PlayerRepository playerRepository
    private PlayerService playerService

    def "AddPlayer"() {
        given:
        playerRepository = Mock(PlayerRepository.class)
        playerService = Mock(PlayerServiceImpl.class)

        when:
        playerService.addPlayer(7L, "Bill Russel", "C", boston)

        then:
        playerService.getAllPlayers() >> ["Bill Russel"]

        where:
        boston = new Team(id: 2L, teamName: "Boston Celtics")
    }

    def "GetAllPlayers"() {
        given:
        playerRepository = Mock(PlayerRepository.class)
        playerService = Mock(PlayerServiceImpl.class)



    }

    def "MapPlayerEntityToDto"() {
    }

    def "GetAllPlayersOfTeam"() {
    }

    def "FindByPlayerName"() {
    }

    def "FindByTeamName"() {
    }

    def "FindByPosition"() {
    }

    def "CreatePageRequest"() {
    }
}
