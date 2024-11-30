package CareYou.careyou.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "programChanges")
public class ProgramChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChangesID")
    private int changesId;

    @Column(name = "ProgramID", nullable = false)
    private int programId;

    @Column(name = "ChangesDesc")
    private String changesDesc;

    @Column(name = "ChangesTarget")
    private int changesTarget;

    @Column(name = "ChangesImage")
    private String changesImage;

    @Column(name = "ChangesEndDate", nullable = false)
    private LocalDateTime changesEndDate;

    @Column(name = "isApproved", nullable = false)
    private boolean isApproved;

    @Column(name = "DateSubmitted", nullable = false)
    private LocalDateTime dateSubmitted;

    @ManyToOne
    @JoinColumn(name = "ProgramID", insertable = false, updatable = false)
    private Program program;

    public int getChangesId() {
        return changesId;
    }

    public void setChangesId(int changesId) {
        this.changesId = changesId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getChangesDesc() {
        return changesDesc;
    }

    public void setChangesDesc(String changesDesc) {
        this.changesDesc = changesDesc;
    }

    public int getChangesTarget() {
        return changesTarget;
    }

    public void setChangesTarget(int changesTarget) {
        this.changesTarget = changesTarget;
    }

    public String getChangesImage() {
        return changesImage;
    }

    public void setChangesImage(String changesImage) {
        this.changesImage = changesImage;
    }

    public LocalDateTime getChangesEndDate() {
        return changesEndDate;
    }

    public void setChangesEndDate(LocalDateTime changesEndDate) {
        this.changesEndDate = changesEndDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDateTime dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
