package pl.mg.projects.players.controllers.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.mg.projects.players.dto.exceptionsHandlerResponseDto.ErrorResponseDto;
import pl.mg.projects.players.services.exceptions.PlayerNotFoundException;
import pl.mg.projects.players.services.exceptions.WrongNewPlayerDetailsException;
import pl.mg.projects.players.utils.ResponseMessagesBuilder;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final ResponseMessagesBuilder responseMessagesBuilder;

    @Autowired
    public RestResponseEntityExceptionHandler(ResponseMessagesBuilder responseMessagesBuilder) {
        this.responseMessagesBuilder = responseMessagesBuilder;
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public final ResponseEntity<ErrorResponseDto> handlePlayerNotFoundException(PlayerNotFoundException ex,
                                                                                WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        String message = responseMessagesBuilder.INTERNAL_SERVER_ERROR(ex, request);
        ErrorResponseDto error = new ErrorResponseDto(message, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongNewPlayerDetailsException.class)
    public final ResponseEntity<ErrorResponseDto> handleWrongNewPlayerDetailsException(PlayerNotFoundException ex,
                                                                                WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        String message = responseMessagesBuilder.INTERNAL_SERVER_ERROR(ex, request);
        ErrorResponseDto error = new ErrorResponseDto(message, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
