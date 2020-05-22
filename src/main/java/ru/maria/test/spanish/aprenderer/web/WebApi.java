package ru.maria.test.spanish.aprenderer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maria.test.spanish.aprenderer.service.WordService;

@RestController(value="/")
public class WebApi {

    @Autowired private WordService service;

    @GetMapping
    public ResponseEntity getAllWords() {
        return new ResponseEntity(service.getAllWords(), HttpStatus.OK);
    }

    @GetMapping(value ="/{alias}", produces = "application/json")
    public ResponseEntity getTopicByAlias(@PathVariable String alias) {
        service.getTopicByAlias(alias);
        return new ResponseEntity(service.getTopicByAlias(alias), HttpStatus.OK);
    }

    @PostMapping(value ="/{alias}", produces = "application/json")
    public ResponseEntity createNewTopic(@PathVariable String alias, @RequestBody String spanish, @RequestBody String russian) {
        return new ResponseEntity(service.createNewTopic(alias,spanish,russian), HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/{alias}", produces = "application/json")
    public ResponseEntity deleteTopicByAlias(@PathVariable String alias) {
        service.deleteTopicWithAllWords(alias);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value ="/{alias}/words", produces = "application/json")
    public ResponseEntity saveWordInTopic(@PathVariable String alias, @RequestBody String spanish, @RequestBody String russian) {
        return new ResponseEntity(service.saveWordInTopic(alias, spanish, russian), HttpStatus.CREATED);

    }

    @DeleteMapping(value ="/{alias}/words", produces = "application/json")
    public ResponseEntity saveWordInTopic(@PathVariable String alias, @RequestBody String spanish) {
        service.deleteWordAtTopic(alias, spanish);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
