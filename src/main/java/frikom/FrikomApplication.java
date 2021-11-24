package frikom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@ComponentScan({"frikom","frikom.util","frikom.controllers"})
public class FrikomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrikomApplication.class, args);
	}

}
