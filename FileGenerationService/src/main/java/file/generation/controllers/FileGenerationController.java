package file.generation.controllers;

import file.generation.services.FileGenerationResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class FileGenerationController {

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "service filegeneration success";
    private static final String ERROR_STATUS = "service filegeneration error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public FileGenerationResponse serviceStatus() {
        return new FileGenerationResponse(SUCCESS_STATUS, 1);
    }
}
