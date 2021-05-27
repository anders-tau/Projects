package file.generation.config;

import file.generation.services.FileGenerationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileGenerationConfig {
    @Value("${serviceWebLink}") String serviceWebLink;

    @Bean
    public FileGenerationService fgService() {
        return new FileGenerationService(serviceWebLink);
    }

}
