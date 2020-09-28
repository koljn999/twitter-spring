package twitter.сontroller;


import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import twitter.models.UserTest;
import twitter.service.UserService;
import twitter.util.CustomErrorType;

import java.security.Principal;

@RestController
@RequestMapping("account")
public class LoginController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    // request method to create a new account by a guest
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserTest newUserTest) {
        if (userService.findUser(newUserTest.getUsername()) != null) {
            logger.error("username Already exist " + newUserTest.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUserTest.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUserTest.setRole("USER");

        return new ResponseEntity<UserTest>(userService.save(newUserTest), HttpStatus.CREATED);
    }

    // this is the login api/service
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Principal user(Principal principal) {
        logger.info("user logged "+principal);
        return principal;
    }

    @CrossOrigin
    @GetMapping("/profile")
    public UserTest getUserByUserName (){
       return userService.findCurrentUser();
    }

    @CrossOrigin
    @PostMapping("/edituser")
    public boolean editUser(@RequestBody UserTest user) {
        return userService.editUser(user);
    }

}

