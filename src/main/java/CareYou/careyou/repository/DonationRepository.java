package CareYou.careyou.repository;


import CareYou.careyou.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findByProgramIdOrderByAmountDesc(int programId);
    
}
