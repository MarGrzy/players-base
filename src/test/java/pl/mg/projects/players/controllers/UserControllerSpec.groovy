package pl.mg.projects.players.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserControllerSpec extends Specification {

    @Autowired (required = false)
    private UserController UserController

    def "when context is loaded then all expected beans are created"() {
        expect: "the UserController is created"
        UserController
    }
}
