package ru.maria.test.spanish.aprenderer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.maria.test.spanish.aprenderer.data.Topic;


@SpringBootTest
public class WordServiceTest {

    @Autowired
    private WordService service;

    @Test
    public void testCreate() {
//        Assertions.assertNotNull(service.getAllWords());
//        String alias = "season";
//        Topic topic = service.createNewTopic(alias, "las estaciones", "времена года");
//        Assertions.assertEquals(topic, service.getTopicByAlias(alias));
//
//        service.saveWordInTopic(alias, "la primavera", "весна");
//        service.saveWordInTopic(alias, "el verano", "лето");
//        service.saveWordInTopic(alias, "el otoño", "осень");
//        service.saveWordInTopic(alias, "el invierno", "зима");
//        Topic topic1 = service.getTopicByAlias(alias);
//
//        Assertions.assertTrue(topic1.getWords().stream().anyMatch(w -> w.getSpanish().equals("la primavera")));
//        Assertions.assertTrue(topic1.getWords().stream().anyMatch(w -> w.getSpanish().equals("el verano")));
//        Assertions.assertTrue(topic1.getWords().stream().anyMatch(w -> w.getSpanish().equals("el otoño")));
//        Assertions.assertTrue(topic1.getWords().stream().anyMatch(w -> w.getSpanish().equals("el invierno")));
//        Assertions.assertEquals(4, topic.getWords().size());
//
//        service.deleteWordAtTopic(alias, "la primavera");
//        topic1 = service.getTopicByAlias(alias);
//
//        Assertions.assertFalse(topic1.getWords().stream().anyMatch(w -> w.getSpanish().equals("la primavera")));
//        Assertions.assertEquals(3, topic.getWords().size());
//
//        service.deleteTopicWithAllWords(alias);
//        Exception exExpected = null;
//        try {
//            service.getTopicByAlias(alias);
//
//        } catch (IllegalArgumentException eAct) {
//            exExpected = eAct;
//        }
//        Assertions.assertNotNull(exExpected);
    }
}
