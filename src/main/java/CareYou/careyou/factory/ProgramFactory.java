package CareYou.careyou.factory;

import CareYou.careyou.model.Program;
import CareYou.careyou.model.ProgramChanges;
import CareYou.careyou.repository.ProgramRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProgramFactory {

    public static Program createNewProgram(int fundraiserId, String topic, String title, String fundraiserName, String beneficiary, String desc, String type, String location, int target, LocalDateTime deadline, String image, String fundraiserIdCard) {
        Program program = new Program();
        program.setFundraiserId(fundraiserId);
        program.setProgramTitle(title);
        program.setProgramDesc(desc);
        program.setProgramStatus("ongoing");
        program.setProgramTopic(topic);
        program.setFundraiserName(fundraiserName);
        program.setBeneficiaryName(beneficiary);
        program.setProgramType(type);
        program.setProgramLoc(location);
        program.setProgramTarget(target);
        program.setProgramRaised(0);
        program.setProgramImage(image);
        program.setFundraiserNationalId(fundraiserIdCard);
        program.setStartDate(LocalDateTime.now());
        program.setEndDate(deadline);
        program.setVerified(false);
        program.setWithdrawn(0);
        return program;
    }

    public static ProgramChanges createProgramChanges(int programId, String desc, int target, LocalDateTime deadline, String image) {
        ProgramChanges changes = new ProgramChanges();
        changes.setProgramId(programId);
        changes.setChangesDesc(desc);
        changes.setChangesTarget(target);
        changes.setChangesEndDate(deadline);
        changes.setChangesImage(image);
        changes.setApproved(false);
        changes.setDateSubmitted(LocalDateTime.now());
        return changes;
    }
}
