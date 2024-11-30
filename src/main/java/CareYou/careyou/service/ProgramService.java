package CareYou.careyou.service;

import CareYou.careyou.factory.ProgramFactory;
import CareYou.careyou.model.Program;
import CareYou.careyou.model.Donation;
import CareYou.careyou.model.ProgramChanges;
import CareYou.careyou.model.ReportedProgram;
import CareYou.careyou.repository.DonationRepository;
import CareYou.careyou.repository.ProgramChangesRepository;
import CareYou.careyou.repository.ProgramRepository;
import CareYou.careyou.repository.ReportedProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private ProgramChangesRepository programChangesRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private ReportedProgramRepository reportedProgramRepository;


    public List<Program> getFirstProgram(int userId) {
        return programRepository.findByFundraiserId(userId);
    }
    public String getReportReason(ReportedProgram report) {
        StringBuilder reason = new StringBuilder();
        if (report.isScamFundraise()) {
            reason.append("Scam Fundraise, ");
        }
        if (report.isFraudFundraise()) {
            reason.append("Fraud Fundraise, ");
        }
        if (report.isThirdPartyBeneficiary()) {
            reason.append("Third-party Beneficiary, ");
        }
        if (report.getOtherReason() != null) {
            reason.append(report.getOtherReason());
        }
        return reason.toString();
    }

    public List<Program> getProgramsByUserId(int userId) {
        return programRepository.findByFundraiserId(userId);
    }

    public void acceptProgram(int programId) {
        Program program = programRepository.findById(programId).orElse(null);
        if (program != null) {
            program.setVerified(true);
            programRepository.save(program);
        }
    }

    public void deleteProgramChanges(int programId) {
        ProgramChanges changes = programChangesRepository.findByProgramId(programId);
        if (changes != null) {
            programChangesRepository.delete(changes);
        }
    }

    public void acceptProgramChanges(int programId) {
        ProgramChanges changes = programChangesRepository.findByProgramId(programId);
        Program program = programRepository.findById(programId).orElse(null);
        if (changes != null && program != null) {
            program.setProgramDesc(changes.getChangesDesc());
            program.setProgramTarget(changes.getChangesTarget());
            program.setEndDate(changes.getChangesEndDate());
            program.setProgramImage(changes.getChangesImage());
            changes.setApproved(true);
            programRepository.save(program);
            programChangesRepository.save(changes);
        }
    }

    public List<Program> getAllProgramsWithReports() {
        return programRepository.findAll().stream()
                .filter(p -> !p.getReportedPrograms().isEmpty() && p.getReportedPrograms().stream().allMatch(rp -> "pending".equals(rp.getReportStatus())))
                .toList();
    }

    public List<ReportedProgram> getAllPendingReports(Program program) {
        return reportedProgramRepository.findByProgramIdAndReportStatus(program.getProgramId(), "pending");
    }

    public Program getProgramById(int programId) {
        return programRepository.findByProgramId(programId);
    }

    public ProgramChanges getProgramChangesById(int programId) {
        return programChangesRepository.findByProgramId(programId);
    }

    public List<Program> getAllVerifiedPrograms(String query) {
        return programRepository.findByVerifiedTrueAndProgramTitleContaining(query);
    }

    public List<Program> getAllVerifiedProgramsFromUserId(String query, int userId) {
        return programRepository.findByVerifiedTrueAndProgramTitleContainingAndFundraiserId(query, userId);
    }

    public List<Program> getAllPendingProgramsFromUserId(String query, int userId) {
        return programRepository.findByVerifiedFalseAndProgramTitleContainingAndFundraiserId(query, userId);
    }

    public List<Program> getAllPendingPrograms() {
        return programRepository.findByVerifiedFalse();
    }

    public List<Program> getAllVerifiedSocialPrograms(String query) {
        return programRepository.findByVerifiedTrueAndProgramTypeAndProgramTitleContaining("social", query);
    }

    public List<Program> getAllVerifiedSocialProgramsFromUserId(String query, int userId) {
        return programRepository.findByVerifiedTrueAndProgramTypeAndProgramTitleContainingAndFundraiserId("social", query, userId);
    }

    public List<Program> getAllPendingSocialProgramsFromUserId(String query, int userId) {
        return programRepository.findByVerifiedFalseAndProgramTypeAndProgramTitleContainingAndFundraiserId( "social", query, userId);
    }

    public List<Program> getAllPendingSocialPrograms() {
        return programRepository.findByVerifiedFalseAndProgramType("social");
    }

    public List<Program> getAllVerifiedProjectPrograms(String query) {
        return programRepository.findByVerifiedTrueAndProgramTypeAndProgramTitleContaining("project", query);
    }

    public List<Program> getAllVerifiedProjectProgramsFromUserId(String query, int userId) {
        return programRepository.findByVerifiedTrueAndProgramTypeAndProgramTitleContainingAndFundraiserId("project", query, userId);
    }

    public List<Program> getAllPendingProjectProgramsFromUserId(String query, int userId) {
        return programRepository.findByVerifiedFalseAndProgramTypeAndProgramTitleContainingAndFundraiserId("project", query, userId);
    }

    public List<Program> getAllPendingProjectPrograms() {
        return programRepository.findByVerifiedFalseAndProgramType("project");
    }

    public List<Donation> getTopDonationsByProgramId(int programId) {
        return donationRepository.findByProgramIdOrderByAmountDesc(programId);
    }

    public List<ProgramChanges> getAllPendingChanges() {
        return programChangesRepository.findByIsApprovedFalse();
    }

    public void deleteProgram(int programId) {
        programRepository.deleteById(programId);
    }

    public ProgramChanges createNewProgramChanges(int programId, String desc, int target, LocalDateTime deadline, String image) {
        ProgramChanges changes = ProgramFactory.createProgramChanges(programId, desc, target, deadline, image);
        return programChangesRepository.save(changes);
    }

    public Program createProgram(int userId, String topic, String title, String name, String beneficiary, String desc, String type, String location, int target, LocalDateTime deadline, String programImg, String idImg) {
        Program program = ProgramFactory.createNewProgram(userId, topic, title, name, beneficiary, desc, type, location, target, deadline, programImg, idImg);
        return programRepository.save(program);
    }

    public void updateProgramRaised(int programId, int amount) {
        Program program = programRepository.findById(programId).orElse(null);
        if (program != null) {
            program.setProgramRaised(program.getProgramRaised() + amount);
            programRepository.save(program);
        }
    }

    public void updateProgramWithdrawn(int programId, int amount) {
        Program program = programRepository.findById(programId).orElse(null);
        if (program != null) {
            program.setWithdrawn(program.getWithdrawn() + amount);
            programRepository.save(program);
        }
    }

    public int getActiveProgramCount() {
        return programRepository.countByVerifiedTrueAndProgramStatus("ongoing");
    }
}
