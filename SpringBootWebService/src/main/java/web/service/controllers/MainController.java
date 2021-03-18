package web.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.models.Fields;
import web.service.services.MainService;

@Controller
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public @ResponseBody String message() {
        return service.message();
    }

    @GetMapping("/form")
    public String ParamsForm(Model model) {
        model.addAttribute("form", new Fields());
        return "form";
    }

    @PostMapping("/form")
    public String ParamsSubmit(@ModelAttribute Fields myFields, Model model) {
        model.addAttribute("form", myFields);
        String jsonobject = "JSON object";
        service.sendRequestToREST("http://localhost:8080/generate", "localhost", jsonobject, myFields);
        return "result";
    }
}
