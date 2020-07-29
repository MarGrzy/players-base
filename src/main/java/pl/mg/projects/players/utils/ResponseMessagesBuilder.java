package pl.mg.projects.players.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Service
public class ResponseMessagesBuilder {

    public String INTERNAL_SERVER_ERROR(Exception ex, WebRequest request) {
        return "Error occured with " + ((ServletWebRequest)request).getRequest().getMethod() +
                " method request: " + ((ServletWebRequest)request).getRequest().getRequestURL()
                + " caused by " + ex.getClass().getSimpleName();
    }
}
