package file.generation.controllers;

import file.generation.services.FileGenerationResponse;
import file.generation.services.FileGenerationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class FileGenerationController {

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "service success";
    private static final String ERROR_STATUS = "service error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

//    @GetMapping
//    public FileGenerationResponse serviceStatus() {
//        return new FileGenerationResponse(SUCCESS_STATUS, 1);
//    }

    //@PostMapping("/file")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public FileGenerationResponse servicePOSTHandling(@RequestParam(value = "key") String key, @RequestBody FileGenerationRequest request) {

        //final FileGenerationResponse response;
        FileGenerationResponse response = new FileGenerationResponse();

        if (sharedKey.equalsIgnoreCase(key)) {
            String itemId = request.getItemId();
            // Process the request
            // ....
            // Return success response to the client.
            response = new FileGenerationResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new FileGenerationResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }
}

