package kz.yersin.flashcards.application.helper;

import kz.yersin.flashcards.application.security.DefaultUserDetails;
import kz.yersin.flashcards.domain.user.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityHelper {

    private SecurityHelper() {
    }

    public static User currentUser() {
        return ((DefaultUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

}
