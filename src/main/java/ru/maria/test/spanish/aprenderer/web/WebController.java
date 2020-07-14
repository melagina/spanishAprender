package ru.maria.test.spanish.aprenderer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.maria.test.spanish.aprenderer.service.WordService;

@Controller
@RequestMapping("view")
public class WebController {

    @Autowired
    private WordService service;

    @GetMapping(value="/index")
    public String getAllWords(Model model) {
        System.out.println("               getAllWords");
        model.addAttribute("topics", service.getAllWords());
        return "view/index";
    }

    @GetMapping(value="/delete/{alias}")
    public String removeTopic(@PathVariable("alias") String alias, Model model) {
        System.out.println("               removeTopic");

        service.deleteTopicWithAllWords(alias);
        model.addAttribute("topics", service.getAllWords());
        return "view/index";
    }

    @GetMapping("/create")
    public String showSignUpForm() {
        return "view/add-word";
    }

//    @PostMapping(value="/view/{alias}")
//    public String addWordIntoTopic(@PathVariable("alias") String alias, Model model) {
//        System.out.println("               addWord");
//
////        service.saveWordInTopic();
//    }


}
