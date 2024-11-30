package CareYou.careyou.factory;

import CareYou.careyou.model.ReportedProgram;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportFactory {

    public static ReportedProgram create(int programId, boolean isScam, boolean isFraud, boolean isThirdParty, String otherReason) {
        ReportedProgram report = new ReportedProgram();
        report.setProgramId(programId);
        report.setScamFundraise(isScam);
        report.setFraudFundraise(isFraud);
        report.setThirdPartyBeneficiary(isThirdParty);
        report.setOtherReason(otherReason);
        report.setDateReported(LocalDateTime.now());
        report.setReportStatus("pending");
        return report;
    }
}
