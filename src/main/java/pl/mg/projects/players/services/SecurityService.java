package pl.mg.projects.players.services;

import pl.mg.projects.players.dto.AuthorizationDto;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(AuthorizationDto authorizationDto);
}
