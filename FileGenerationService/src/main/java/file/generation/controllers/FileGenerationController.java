package file.generation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import file.generation.models.FileGenerationEvent;
import file.generation.services.FileGenerationResponse;
import file.generation.dao.FileGenerationEventDAO;
import file.generation.services.FileGenerationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class FileGenerationController {

    private static final String SUCCESS_STATUS = "http_ok";
    private static final String EMPTY_STATUS = "no_content";

    private final FileGenerationService fileGenerationService;

    private final FileGenerationEventDAO fileGenerationEventDAO;

    public FileGenerationController(FileGenerationService service, FileGenerationEventDAO fileGenerationEventDAO) {
        this.fileGenerationService = service;
        this.fileGenerationEventDAO = fileGenerationEventDAO;
    }

    @GetMapping("/status")
    public FileGenerationResponse serviceStatus() {
        int codeHttpOk = 200;
        return new FileGenerationResponse(SUCCESS_STATUS, codeHttpOk);
    }

    @GetMapping("/answer")
    public FileGenerationResponse serviceAnswer() throws SQLException, IOException {
        int codeHttpOk = 200;
        int codeNoContent = 204;
        if (fileGenerationEventDAO.countAll("events_ready") != 0) {
            FileGenerationEvent eventReadyFirst = fileGenerationEventDAO.findFirst("events_ready");
            fileGenerationService.sendFileToWebService(eventReadyFirst, fileGenerationEventDAO);
            return new FileGenerationResponse(SUCCESS_STATUS, codeHttpOk);
        } else {
            return new FileGenerationResponse(EMPTY_STATUS, codeNoContent);
        }
    }

    @PostMapping("/generate")
    public FileGenerationResponse serviceGenerate(@RequestBody String body) throws SQLException, IOException {
        int codeHttpCreated = 201;
        FileGenerationEvent event = new ObjectMapper().readValue(body, FileGenerationEvent.class);
        System.out.println(body);
        fileGenerationEventDAO.create(event, "events");
        return new FileGenerationResponse(SUCCESS_STATUS, codeHttpCreated);
    }
}
