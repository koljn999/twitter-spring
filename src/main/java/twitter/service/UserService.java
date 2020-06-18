package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter.models.User;
import twitter.reposetory.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByNikName(String nikName) {
        User user = userRepository.findByNikName(nikName);
        return user;
    }

}
