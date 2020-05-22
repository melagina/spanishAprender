package ru.maria.test.spanish.aprenderer.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Topic {
    private long id;
    private String alias;
    private String spanish;
    private String russian;
    private List<Word> words;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;
        Topic topic = (Topic) o;
        return alias.equals(topic.alias) &&
                spanish.equals(topic.spanish) &&
                russian.equals(topic.russian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias, spanish, russian);
    }
}
