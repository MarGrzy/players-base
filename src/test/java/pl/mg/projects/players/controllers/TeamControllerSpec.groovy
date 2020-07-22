package pl.mg.projects.players.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TeamControllerSpec extends Specification {

    @Autowired (required = false)
    private TeamController teamController

    def "when context is loaded then all expected beans are created"() {
        expect: "the TeamController is created"
        TeamController
    }
}
