package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import twitter.models.User;
import twitter.reposetory.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nikName) throws UsernameNotFoundException {
        User myUser = userRepository.findByNikName(nikName);
        if(myUser==null){
            throw new UsernameNotFoundException("Unknown user "+nikName);
        }
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username(myUser.getNikName())
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();
        return user;
    }
}
