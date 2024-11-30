package CareYou.careyou.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController extends BaseController {


    @GetMapping("/")
    public String home(Principal principal, Model model) {
    	if (principal != null) {
            model.addAttribute("username", principal.getName());
            
        } else {
            model.addAttribute("username", "Anonymous");
        }
    	setCommonAttributes(principal, model, "home");

        // Additional logic
        return "home";
    }

}
