package CareYou.careyou.repository;


import CareYou.careyou.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int userId);

    User findByUserName(String userName);

    User findByUserEmail(String userEmail);

    List<User> findByRoleOrderByTransactionsAmountDesc(String role);

    List<User> findByRoleOrderByTransactionsAmountDesc(String role, org.springframework.data.domain.Pageable pageable);

    long count();

    long countByJoinDateAfter(LocalDateTime date);
}
