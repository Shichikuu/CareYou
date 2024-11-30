package CareYou.careyou.factory;

import CareYou.careyou.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserFactory {
	
	@Autowired
    private static PasswordEncoder passwordEncoder;

    public static User create(String name, String email, String password) {
        User user = new User();
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPassword(passwordEncoder.encode(password));
        user.setRole("user");
        user.setJoinDate(LocalDateTime.now());
        user.setUserStatus("safe");
        user.setProfilePicture("ProfileDefault.jpg");
        return user;
    }
}
