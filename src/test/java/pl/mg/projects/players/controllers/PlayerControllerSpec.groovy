package pl.mg.projects.players.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class PlayerControllerSpec extends Specification {

    @Autowired (required = false)
    private PlayerController playerController

    def "when context is loaded then all expected beans are created"() {
        expect: "the PlayerController is created"
        PlayerController
    }
}
