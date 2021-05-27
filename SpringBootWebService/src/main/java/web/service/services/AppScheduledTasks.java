package web.service.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AppScheduledTasks {

    private final AppService appService;

    public AppScheduledTasks(AppService appService) {
        this.appService = appService;
    }

    @Scheduled(fixedDelayString = "${fixedDelay}")
    public void eventHandler() throws IOException {
        System.out.println(appService.sendGETRequestToRESTService());
    }
}
