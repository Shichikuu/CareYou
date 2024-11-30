package CareYou.careyou.repository;

import CareYou.careyou.model.ReportedProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportedProgramRepository extends JpaRepository<ReportedProgram, Integer> {

    List<ReportedProgram> findAll();

    ReportedProgram findByReportId(int reportId);

    List<ReportedProgram> findByProgramId(int programId);

    List<ReportedProgram> findByReportStatus(String reportStatus);

    List<ReportedProgram> findByProgramIdAndReportStatus(int programId, String reportStatus);
}
