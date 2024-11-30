package CareYou.careyou.factory;

import  CareYou.careyou.model.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationFactory {

    public static Organization create(int userId, String name, String type, String location, String phone, String email, String website, String leaderName, String cert) {
        Organization organization = new Organization();
        organization.setUserId(userId);
        organization.setName(name);
        organization.setType(type);
        organization.setLocation(location);
        organization.setPhoneNumber(phone);
        organization.setEmail(email);
        organization.setWebsite(website);
        organization.setLeaderName(leaderName);
        organization.setCertificate(cert);
        organization.setVerified(false);
        return organization;
    }

    public static Organization create(int userId, String name, String type, String location, String phone, String email, String leaderName, String cert) {
        Organization organization = new Organization();
        organization.setUserId(userId);
        organization.setName(name);
        organization.setType(type);
        organization.setLocation(location);
        organization.setPhoneNumber(phone);
        organization.setEmail(email);
        organization.setLeaderName(leaderName);
        organization.setCertificate(cert);
        organization.setVerified(false);
        return organization;
    }
}
