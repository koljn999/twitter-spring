package twitter.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import twitter.models.UserTest;

/**
 * @author Ekaterina Pyataeva on 22.09.2020.
 */
public class CurrentUserHelper {

    public static String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
