package twitter.Controllers;

import org.springframework.web.bind.annotation.*;
import twitter.models.AuthenticationBean;
import twitter.models.User;
import twitter.service.PostService;
import twitter.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class loginController {

    private  UserService userService;
    private User thisUser;

    public loginController(UserService userService) {

        this.userService = userService;
    }



}

