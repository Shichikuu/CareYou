package CareYou.careyou.service;

import CareYou.careyou.factory.UserFactory;
import CareYou.careyou.model.User;
import CareYou.careyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getTopOrganization(int rank) {
        List<User> organizations = userRepository.findByRoleOrderByTransactionsAmountDesc("organization", PageRequest.of(rank - 1, 1));
        return organizations.isEmpty() ? null : organizations.get(0);
    }

    public User getTopUser(int rank) {
        List<User> users = userRepository.findByRoleOrderByTransactionsAmountDesc("user", PageRequest.of(rank - 1, 1));
        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> getUsersInRange(String role, int startRank, int endRank) {
        int size = endRank - startRank + 1;
        return userRepository.findByRoleOrderByTransactionsAmountDesc(role, PageRequest.of(startRank - 1, size));
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public void updateUserProfile(User user, String name, String email, String password) {
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public User register(String name, String email, String password) {
        User user = UserFactory.create(name, email, password);
        return userRepository.save(user);
    }

    public void changeRole(User user, String role) {
        user.setRole(role);
        userRepository.save(user);
    }

    public void updateProfilePicture(User user, String path) {
        user.setProfilePicture(path);
        userRepository.save(user);
    }

    public long getUserCount() {
        return userRepository.count();
    }

    public long getNewUserCount() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        return userRepository.countByJoinDateAfter(oneMonthAgo);
    }
}
