package ru.maria.test.spanish.aprenderer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maria.test.spanish.aprenderer.data.Topic;
import ru.maria.test.spanish.aprenderer.service.WordService;

@Controller
@RequestMapping("view/index")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public String getAllWords(Model model) {
        System.out.println("               getAllWords");
        model.addAttribute("topics", wordService.getAllWords());
        return "view/index";
    }

    @PostMapping
    public String addNewWord(Model model, String russian, String spanish, String topicAlias) {
        System.out.println("               addNewWord");
        wordService.saveWordInTopic(topicAlias, spanish, russian);
        model.addAttribute("topics", wordService.getAllWords());
        return "view/index";
    }

    @GetMapping(value = "/delete/{alias}")
    public String removeTopic(@PathVariable("alias") String alias, Model model) {
        System.out.println("               removeTopic");

        wordService.deleteTopicWithAllWords(alias);
        model.addAttribute("topics", wordService.getAllWords());
        return "view/index";
    }


}
