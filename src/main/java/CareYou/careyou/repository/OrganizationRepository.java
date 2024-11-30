package CareYou.careyou.repository;

import CareYou.careyou.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    Organization findByUserId(int userId);

    Organization findByName(String name);

    Organization findByEmail(String email);

    List<Organization> findByIsVerifiedFalse();
}
