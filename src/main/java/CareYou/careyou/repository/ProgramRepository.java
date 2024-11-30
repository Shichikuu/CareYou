package CareYou.careyou.repository;

import CareYou.careyou.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {

    List<Program> findByFundraiserId(int fundraiserId);

    Program findByProgramId(int programId);

    List<Program> findByVerifiedTrueAndProgramTitleContaining(String query);

    List<Program> findByVerifiedTrueAndProgramTitleContainingAndFundraiserId(String query, int fundraiserId);

    List<Program> findByVerifiedFalseAndProgramTitleContainingAndFundraiserId(String query, int fundraiserId);

    List<Program> findByVerifiedFalse();

    List<Program> findByVerifiedTrueAndProgramTypeAndProgramTitleContaining(String programType, String query);

    List<Program> findByVerifiedTrueAndProgramTypeAndProgramTitleContainingAndFundraiserId(String programType, String query, int fundraiserId);

    List<Program> findByVerifiedFalseAndProgramTypeAndProgramTitleContainingAndFundraiserId(String programType, String query, int fundraiserId);

    List<Program> findByVerifiedFalseAndProgramType(String programType);

    List<Program> findByVerifiedTrueAndProgramType(String programType);

    int countByVerifiedTrueAndProgramStatus(String programStatus);
}
