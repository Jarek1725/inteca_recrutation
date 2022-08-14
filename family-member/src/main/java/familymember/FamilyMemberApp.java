package familymember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FamilyMemberApp {
    public static void main(String[] args) {
        SpringApplication.run(FamilyMemberApp.class, args);
    }
}
