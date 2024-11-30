package CareYou.careyou.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProgramID")
    private int programId;

    @Column(name = "FundraiserID", nullable = false)
    private int fundraiserId;

    @Column(name = "ProgramTitle", nullable = false)
    private String programTitle;

    @Column(name = "ProgramDesc")
    private String programDesc;

    @Column(name = "ProgramStatus")
    private String programStatus;

    @Column(name = "ProgramTopic")
    private String programTopic;

    @Column(name = "FundraiserName")
    private String fundraiserName;

    @Column(name = "BeneficiaryName")
    private String beneficiaryName;

    @Column(name = "ProgramType")
    private String programType;

    @Column(name = "ProgramLoc")
    private String programLoc;

    @Column(name = "ProgramTarget")
    private int programTarget;

    @Column(name = "ProgramRaised")
    private int programRaised;

    @Column(name = "ProgramImage")
    private String programImage;

    @Column(name = "StartDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "Verified", nullable = false)
    private boolean verified;

    @Column(name = "Withdrawn")
    private int withdrawn;

    @Column(name = "FundraiserNationalID")
    private String fundraiserNationalId;

    @ManyToOne
    @JoinColumn(name = "FundraiserID", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "program")
    private Set<ProgramChanges> programChanges = new HashSet<>();

    @OneToMany(mappedBy = "program")
    private Set<ReportedProgram> reportedPrograms = new HashSet<>();

    @OneToMany(mappedBy = "program")
    private Set<Transaction> transactions = new HashSet<>();

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getFundraiserId() {
        return fundraiserId;
    }

    public void setFundraiserId(int fundraiserId) {
        this.fundraiserId = fundraiserId;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getProgramDesc() {
        return programDesc;
    }

    public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
    }

    public String getProgramStatus() {
        return programStatus;
    }

    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
    }

    public String getProgramTopic() {
        return programTopic;
    }

    public void setProgramTopic(String programTopic) {
        this.programTopic = programTopic;
    }

    public String getFundraiserName() {
        return fundraiserName;
    }

    public void setFundraiserName(String fundraiserName) {
        this.fundraiserName = fundraiserName;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getProgramLoc() {
        return programLoc;
    }

    public void setProgramLoc(String programLoc) {
        this.programLoc = programLoc;
    }

    public int getProgramTarget() {
        return programTarget;
    }

    public void setProgramTarget(int programTarget) {
        this.programTarget = programTarget;
    }

    public int getProgramRaised() {
        return programRaised;
    }

    public void setProgramRaised(int programRaised) {
        this.programRaised = programRaised;
    }

    public String getProgramImage() {
        return programImage;
    }

    public void setProgramImage(String programImage) {
        this.programImage = programImage;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(int withdrawn) {
        this.withdrawn = withdrawn;
    }

    public String getFundraiserNationalId() {
        return fundraiserNationalId;
    }

    public void setFundraiserNationalId(String fundraiserNationalId) {
        this.fundraiserNationalId = fundraiserNationalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProgramChanges> getProgramChanges() {
        return programChanges;
    }

    public void setProgramChanges(Set<ProgramChanges> programChanges) {
        this.programChanges = programChanges;
    }

    public Set<ReportedProgram> getReportedPrograms() {
        return reportedPrograms;
    }

    public void setReportedPrograms(Set<ReportedProgram> reportedPrograms) {
        this.reportedPrograms = reportedPrograms;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
