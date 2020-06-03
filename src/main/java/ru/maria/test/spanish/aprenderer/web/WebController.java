package ru.maria.test.spanish.aprenderer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.maria.test.spanish.aprenderer.service.WordService;

@Controller(value="/view")
public class WebController {

    @Autowired
    private WordService service;

    @GetMapping(value="/view")
    public String getAllWords(Model model) {
        model.addAttribute("topics", service.getAllWords());
        return "view/index";
    }
}
