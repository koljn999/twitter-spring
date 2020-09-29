package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import twitter.models.UserTest;

/**
 * @author Ekaterina Pyataeva on 18.09.2020.
 */
@Service
public class AppUserDetailService implements UserDetailsService {

    private final UserService userService;

    public AppUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTest userTest = userService.findUser(username);
        return userTest;
    }
}
