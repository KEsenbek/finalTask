package kg.megacom.finaltask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("kg.megacom.finaltask.microservices")
public class FinalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalTaskApplication.class, args);
    }

}
