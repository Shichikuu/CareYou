package CareYou.careyou.service;

import CareYou.careyou.factory.ReportFactory;
import CareYou.careyou.model.ReportedProgram;
import CareYou.careyou.repository.ReportedProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportedProgramService {

    @Autowired
    private ReportedProgramRepository reportedProgramRepository;

    public List<ReportedProgram> getReports() {
        return reportedProgramRepository.findAll();
    }

    public void approveReport(int reportId) {
        ReportedProgram report = reportedProgramRepository.findById(reportId).orElse(null);
        if (report != null) {
            report.setReportStatus("resolved");
            reportedProgramRepository.save(report);
        }
    }

    public ReportedProgram getReportById(int id) {
        return reportedProgramRepository.findById(id).orElse(null);
    }

    public void addReport(ReportedProgram report) {
        reportedProgramRepository.save(report);
    }

    public void updateReport(ReportedProgram report) {
        reportedProgramRepository.save(report);
    }

    public void deleteReport(int id) {
        reportedProgramRepository.deleteById(id);
    }

    public ReportedProgram createNewReport(int programId, boolean isScam, boolean isFraud, boolean isThirdParty, String otherReason) {
        ReportedProgram report = ReportFactory.create(programId, isScam, isFraud, isThirdParty, otherReason);
        return reportedProgramRepository.save(report);
    }
}
