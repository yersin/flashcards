package kz.yersin.flashcards.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameNotAvailableException extends RuntimeException {

    public UsernameNotAvailableException(String username) {
        super("This username is not available: " + username);
    }

}
