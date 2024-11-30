package CareYou.careyou.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
    	SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        // Set the location of your templates
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        // Set the template mode to HTML
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        // Enable caching (set to false if you want to disable it during development)
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
    	SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // Set the template resolver
        templateEngine.setTemplateResolver(templateResolver);
        // Add the Spring Security dialect
        templateEngine.addDialect(new SpringSecurityDialect());
        // Additional dialects can be added here
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
    	ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        // Set the template engine
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");
        // Optionally set the order and view names
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[] {".html", ".xhtml"});
        return viewResolver;
    }
}
