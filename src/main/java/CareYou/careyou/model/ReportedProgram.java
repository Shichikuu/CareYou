package CareYou.careyou.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportedPrograms")
public class ReportedProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportID")
    private int reportId;

    @Column(name = "ProgramID", nullable = false)
    private int programId;

    @Column(name = "OtherReason")
    private String otherReason;

    @Column(name = "ScamFundraise", nullable = false)
    private boolean scamFundraise;

    @Column(name = "FraudFundraise", nullable = false)
    private boolean fraudFundraise;

    @Column(name = "ThirdpartyBeneficiary", nullable = false)
    private boolean thirdPartyBeneficiary;

    @Column(name = "ReportStatus")
    private String reportStatus;

    @Column(name = "DateReported", nullable = false)
    private LocalDateTime dateReported;

    @Column(name = "ReporterID")
    private Integer reporterId;

    @ManyToOne
    @JoinColumn(name = "ProgramID", insertable = false, updatable = false)
    private Program program;

    @ManyToOne
    @JoinColumn(name = "ReporterID", insertable = false, updatable = false)
    private User user;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getOtherReason() {
        return otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public boolean isScamFundraise() {
        return scamFundraise;
    }

    public void setScamFundraise(boolean scamFundraise) {
        this.scamFundraise = scamFundraise;
    }

    public boolean isFraudFundraise() {
        return fraudFundraise;
    }

    public void setFraudFundraise(boolean fraudFundraise) {
        this.fraudFundraise = fraudFundraise;
    }

    public boolean isThirdPartyBeneficiary() {
        return thirdPartyBeneficiary;
    }

    public void setThirdPartyBeneficiary(boolean thirdPartyBeneficiary) {
        this.thirdPartyBeneficiary = thirdPartyBeneficiary;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public LocalDateTime getDateReported() {
        return dateReported;
    }

    public void setDateReported(LocalDateTime dateReported) {
        this.dateReported = dateReported;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
