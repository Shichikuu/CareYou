package CareYou.careyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import CareYou.careyou.dto.LoginForm;

@Controller
public class LoginController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String loginPage(Model model, String error) {
        if (error != null) {
            model.addAttribute("loginError", "Invalid email or password");
        }
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
        }
        return "login";
    }
    
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
    	try {
            // Authenticate user with Spring Security's AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword())
            );

            // If authentication was successful, set the authentication in the security context
            if (authentication.isAuthenticated()) {
                return "redirect:/home";  // Redirect to the home page or desired destination
            }

        } catch (AuthenticationException ex) {
            model.addAttribute("loginError", "Invalid username or password.");
            return "login";  // Return to the login page with an error
        }

        return "login";  // Return to the login page if authentication fails for any reason
    }
}
