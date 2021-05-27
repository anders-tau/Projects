package file.generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.logging.LogManager;

@SpringBootApplication
@EnableScheduling
public class FileGenerationMainClass {
    public static void main(String[] args) {
        SpringApplication.run(FileGenerationMainClass.class, args);
        try {
            LogManager.getLogManager().readConfiguration(FileGenerationMainClass.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Couldn't setup logger configuration: " + e.toString());
        }
    }
}
