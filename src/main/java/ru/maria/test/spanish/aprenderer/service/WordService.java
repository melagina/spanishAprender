package ru.maria.test.spanish.aprenderer.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import ru.maria.test.spanish.aprenderer.data.Topic;
import ru.maria.test.spanish.aprenderer.data.Word;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    private static final List<Topic> MODEL = new ArrayList<>();
    static {
        List<Word> words = new ArrayList<>();
        words.add(new Word(1, "week","Lunes", "Понедельник"));
        words.add(new Word(2, "week","Martes", "Вторник"));
        words.add(new Word(3, "week","Miércoles", "Среда"));
        words.add(new Word(4, "week","Jueves", "Четверг"));
        words.add(new Word(5, "week","Viernes", "Пятница"));
        words.add(new Word(6, "week","Sábado", "Суббота"));
        words.add(new Word(7, "week","Domingo", "Воскресенье"));
        Topic c = new Topic(0L, "week", "Los días de la semana","Дни недели", words);
        MODEL.add(c);
    }

    public List<Topic> getAllWords() {
        return ImmutableList.copyOf(MODEL);
    }

    public Topic getTopicByAlias(String alias) {
        System.out.println("  topic = " + alias);
        return MODEL.stream()
                .filter( topic -> topic.getAlias().equals(alias))
                .findAny().orElseThrow(() -> new IllegalArgumentException("Topic not found!"));
    }

    public Topic createNewTopic(String alias, String spanish, String russian) {
        Topic topic = new Topic(-1L, alias, spanish, russian, new ArrayList<>());
        MODEL.add(topic);
        return topic;
    }

    public void deleteTopicWithAllWords(String topicAlias) {
        Topic topic = MODEL.stream()
                .filter( t -> t.getAlias().equals(topicAlias))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Topic not found!"));
        MODEL.remove(topic);
    }

    public Word saveWordInTopic(String topicAlias, String spanish, String russian) {
        Topic topic = MODEL.stream()
                .filter( t -> t.getAlias().equals(topicAlias))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Topic not found!"));
        Word word = new Word(-1,topicAlias, spanish, russian);
        topic.getWords().add(word);
        return word;
    }

    public void deleteWordAtTopic(String topicAlias, String spanish) {
        Topic topic = MODEL.stream()
                .filter( t -> t.getAlias().equals(topicAlias))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Topic not found!"));
        Word word = topic.getWords().stream()
                .filter( w -> w.getSpanish() == spanish)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Word not found!"));
        topic.getWords().remove(word);
    }
}
