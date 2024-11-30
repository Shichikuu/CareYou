package CareYou.careyou.repository;

import CareYou.careyou.model.ProgramChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramChangesRepository extends JpaRepository<ProgramChanges, Integer> {

    ProgramChanges findByProgramId(int programId);

    List<ProgramChanges> findByIsApprovedFalse();
}
