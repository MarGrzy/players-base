package pl.mg.projects.players.controllers


import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import pl.mg.projects.players.dto.Direction
import pl.mg.projects.players.dto.SortField
import pl.mg.projects.players.entities.Player
import pl.mg.projects.players.entities.Team
import pl.mg.projects.players.services.PlayerService
import spock.lang.Specification

@SpringBootTest
class PlayerControllerSpec extends Specification {

    // initial setup and variables

    @Autowired(required = false)
    private PlayerController playerController
    private PlayerService playerService

    private MockMvc mockMvc
    private ObjectMapper objectMapper = new ObjectMapper()

    def requestUri = '/player'

    // testing data

    private Player mj
    private String mjJsonString

    private Player mr
    private String mrJsonString

    private Player lb
    private String lbJsonString

    private Team chi
    private Team sac
    private Team bos

    void setup() {
        playerService = Mock(PlayerService.class)
        playerController = Mock(playerController.class as Class<Object>) as PlayerController
        mockMvc = MockMvcBuilders
                .standaloneSetup(playerController)
                .alwaysDo(MockMvcResultHandlers.print())
                .build()

        chi = new Team([id: 1, teamName: 'Chicago Bulls'])
        mj = new Player([id: 1, playerName: 'Michael Jordan', position: 'SG', team: chi])
        mjJsonString = objectMapper.writeValueAsString(mj)

        sac = new Team([id: 2, teamName: 'Sacramento Kings'])
        mr = new Player([id: 2, playerName: 'Mitch Richmond', position: 'SG', team: sac])
        mrJsonString = objectMapper.writeValueAsString(mr)

        bos = new Team([id: 3, teamName: 'Boston Celtics'])
        lb = new Player([id: 3, playerName: 'Larry Bird', position: 'SF/PF', team: bos])
        lbJsonString = objectMapper.writeValueAsString(lb)
    }

//    void 'get all players return a sorted by playerName starting with "Mi" list of players in json'() {
//        given:
//        playerService.findByPlayerName(2, 0, SortField.playerName, Direction.asc, "Mi") >> [mj, mr]
//
//        when: "get all players whose names starts with Mi"
//        def response = [mjJsonString, mrJsonString].toString()
//        println response
//
//        then:
//        mockMvc.perform(MockMvcRequestBuilders
//                .get(requestUri)
//                    .param("perPage", "2")
//                    .param("page", "0")
//                    .param("sortBy", "playerName")
//                    .param("direction", "asc")
//                    .param("playerName", "Mi")
//                    .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(response as String))
//    }
}
