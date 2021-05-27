package web.service.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.misc.AppTextProcessing;
import web.service.models.AppFields;
import web.service.services.AppService;

import java.io.IOException;

@Controller
public class AppController {

    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("form", new AppFields());
        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@ModelAttribute AppFields myAppFields, Model model) throws IOException {
        model.addAttribute("form", myAppFields);
        service.sendPOSTRequestToRESTService(myAppFields);
        return "result";
    }

    @PostMapping("/file")
    public String getFile(@RequestBody String body) throws IOException {
        AppFields fields = new ObjectMapper().readValue(body, AppFields.class);
        AppTextProcessing fileText = new AppTextProcessing();
        fileText.createTextFile(fields);
        return "file";
    }
}
