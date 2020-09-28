package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import twitter.models.UserTest;
import twitter.repository.UserRepository;
import twitter.util.CurrentUserHelper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserTest save(UserTest userTest){
        return userRepository.saveAndFlush(userTest);
    }

    public UserTest update(UserTest userTest){
        return userRepository.save(userTest);
    }

    public UserTest findUser(String userName){
        return userRepository.findUserByUsername(userName);
    }

    public UserTest findCurrentUser() {
        return findUser(CurrentUserHelper.getCurrentUser());
    }

    public boolean editUser(UserTest editorUser) {
        UserTest currentUser = userRepository.findUserByUsername(CurrentUserHelper.getCurrentUser());
        currentUser.setFirstName(editorUser.getFirstName());
        currentUser.setLastName(editorUser.getLastName());
        currentUser.setBirthday(editorUser.getBirthday());
        currentUser.setPhone(editorUser.getPhone());
        currentUser.setProfession(editorUser.getProfession());
        if (userRepository.save(currentUser) instanceof UserTest) return true;
        else return false;
    }

//    public User find(Long id){
//      return userRepository.findOne(id);
//    }



}
