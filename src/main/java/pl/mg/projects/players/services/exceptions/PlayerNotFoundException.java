package pl.mg.projects.players.services.exceptions;

public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException(String errorMessage) {
        super (errorMessage);
    }
}
