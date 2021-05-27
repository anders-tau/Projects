package file.generation.services;

import file.generation.dao.FileGenerationEventDAO;
import file.generation.misc.FileGenerationTextProcessing;
import file.generation.models.FileGenerationEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class FileGenerationScheduledTasks {

    private final FileGenerationEventDAO fileGenerationEventDAO;

    public FileGenerationScheduledTasks(FileGenerationEventDAO fileGenerationEventDAO) {
        this.fileGenerationEventDAO = fileGenerationEventDAO;
    }

    @Scheduled(fixedDelayString = "${fixedDelay}")
    public void eventHandler() throws SQLException, IOException {
        if (fileGenerationEventDAO.countAll("events") != 0) {
            FileGenerationEvent eventFirst = fileGenerationEventDAO.findFirst("events");
            FileGenerationTextProcessing fileText = new FileGenerationTextProcessing();
            fileText.createTextFile(eventFirst);
            fileGenerationEventDAO.delete(eventFirst.getDateTime(), "events");
            fileGenerationEventDAO.create(eventFirst, "events_ready");
        } else {
            System.out.println("Queue's empty");
        }
    }
}
