package ru.maria.test.spanish.aprenderer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.maria.test.spanish.aprenderer.service.WordService;

@Controller(value="/view")
public class WebController {

    @Autowired
    private WordService service;

    @GetMapping(value="/view/index")
    public String getAllWords(Model model) {
        System.out.println("               getAllWords");
        model.addAttribute("topics", service.getAllWords());
        return "view/index";
    }

    @GetMapping(value="/view/delete/{alias}")
    public String removeTopic(@PathVariable("alias") String alias, Model model) {
        System.out.println("               removeTopic");

        service.deleteTopicWithAllWords(alias);
        model.addAttribute("topics", service.getAllWords());
        return "view/index";
    }


}
