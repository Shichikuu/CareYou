package CareYou.careyou.service;

import CareYou.careyou.model.Organization;
import CareYou.careyou.model.User;
import CareYou.careyou.repository.OrganizationRepository;
import CareYou.careyou.repository.UserRepository;
import CareYou.careyou.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserRepository userRepository;

    public void rejectOrganization(int userId) {
        Organization organization = organizationRepository.findByUserId(userId);
        if (organization != null) {
            organization.setRole("user");
            userRepository.save(organization);
            organizationRepository.delete(organization);
        }
    }

    public void acceptOrganization(int userId) {
        Organization organization = organizationRepository.findByUserId(userId);
        if (organization != null) {
            organization.setVerified(true);
            organizationRepository.save(organization);
        }
    }

    public Organization getOrganizationByUserId(int userId) {
        return organizationRepository.findByUserId(userId);
    }

    public Organization getOrganizationByName(String name) {
        return organizationRepository.findByName(name);
    }

    public Organization getOrganizationByEmail(String email) {
        return organizationRepository.findByEmail(email);
    }

    public Response<Object> createOrganization(int userId, String name, String type, String location, String phone, String email, String leaderName, MultipartFile certFile) {
        Organization existingOrganization = organizationRepository.findByEmail(email.toLowerCase());
        if (existingOrganization != null) {
            return new Response<>(false, "Email already registered", "email", null);
        }
        String certPath = uploadFile(certFile, "Organization/cert/");
        Organization organization = new Organization();
        organization.setUserId(userId);
        organization.setName(name);
        organization.setType(type);
        organization.setLocation(location);
        organization.setPhoneNumber(phone);
        organization.setEmail(email.toLowerCase());
        organization.setLeaderName(leaderName);
        organization.setCertificate(certPath);
        organization.setVerified(false);
        organization = organizationRepository.save(organization);
        return new Response<>(true, "", "", organization);
    }

    public List<Organization> getAllPendingOrganizations() {
        return organizationRepository.findByIsVerifiedFalse();
    }

    private String uploadFile(MultipartFile file, String path) {
        // Handle file upload and return the file path
        // Ensure to handle exceptions and I/O operations
        return "uploaded_file_path";
    }
}
