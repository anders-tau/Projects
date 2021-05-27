package web.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppMainClass {
    public static void main(String[] args) {
        SpringApplication.run(AppMainClass.class, args);
    }
}
