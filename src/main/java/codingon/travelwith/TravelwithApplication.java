package codingon.travelwith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableConfigurationProperties(StorageProperties.class)
public class TravelwithApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelwithApplication.class, args);
	}

}

