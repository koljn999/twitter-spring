package twitter.Controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import twitter.models.AuthenticationBean;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@RestController
public class loginController {

    @GetMapping("/api/login")
    public AuthenticationBean basicauth() {

        return new AuthenticationBean("You are authenticated");
    }



}
