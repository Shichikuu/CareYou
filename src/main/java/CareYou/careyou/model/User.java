package CareYou.careyou.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entity_type")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;

    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "UserEmail", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "UserPassword", nullable = false)
    private String userPassword;

    @Column(name = "JoinDate", nullable = false)
    private LocalDateTime joinDate;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "ProfilePicture")
    private String profilePicture;

    @Column(name = "UserStatus")
    private String userStatus;

    @OneToMany(mappedBy = "user")
    private Set<Program> programs = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ReportedProgram> reportedPrograms = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Set<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
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
