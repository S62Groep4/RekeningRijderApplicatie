package service;

import domain.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Init {
    
    @Inject
    UserService userService;
    
    @PostConstruct
    public void init() {
        User user = new User("gebruiker@mail.com", "1234");
        userService.insertUser(user);
    }

}
