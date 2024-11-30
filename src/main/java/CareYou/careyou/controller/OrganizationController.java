package CareYou.careyou.controller;

import CareYou.careyou.dto.Response;
import CareYou.careyou.model.Organization;
import CareYou.careyou.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create")
    public Response<Object> createOrganization(
            @RequestParam int userId,
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam String location,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String leaderName,
            @RequestParam MultipartFile certFile) {

        return organizationService.createOrganization(userId, name, type, location, phone, email, leaderName, certFile);
    }

    // Other endpoints...
}
