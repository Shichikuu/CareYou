package CareYou.careyou.controller;

import CareYou.careyou.model.Organization;
import CareYou.careyou.model.User;
import CareYou.careyou.repository.UserRepository;
import CareYou.careyou.service.OrganizationService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public abstract class BaseController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserRepository userRepository;

    protected void setCommonAttributes(Principal principal, Model model, String activePage) {
        User user = null;
        if (principal != null) {
            String email = principal.getName();
            user = userRepository.findByUserEmail(email);
        }
        model.addAttribute("user", user);
        model.addAttribute("activePage", activePage);
       

        boolean showOrgNotification = false;
        if (user != null && "organization".equals(user.getRole())) {
            Organization org = organizationService.getOrganizationByUserId(user.getUserId());
            if (org == null || !org.isVerified()) {
                showOrgNotification = true;
            }
        }
        model.addAttribute("showOrgNotification", showOrgNotification);
    }


}

