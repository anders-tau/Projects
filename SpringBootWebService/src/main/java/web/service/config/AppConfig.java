package web.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import web.service.services.AppService;

@Configuration
@EnableScheduling
public class AppConfig {
    @Value("${serviceREST.generate}") String serviceRESTGenerate;
    @Value("${serviceREST.answer}") String serviceRESTAnswer;

    @Bean
    public AppService appService() {
        return new AppService(serviceRESTGenerate, serviceRESTAnswer);
    }

}
