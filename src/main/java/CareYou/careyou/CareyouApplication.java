package CareYou.careyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "CareYou.careyou.repository")
@SpringBootApplication
public class CareyouApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareyouApplication.class, args);
	}

}
