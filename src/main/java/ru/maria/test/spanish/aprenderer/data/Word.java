package ru.maria.test.spanish.aprenderer.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Word {
    private long id;
    private String topicAlias;
    private String spanish;//
    private String russian;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return topicAlias.equals(word.topicAlias) &&
                spanish.equals(word.spanish) &&
                russian.equals(word.russian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicAlias, spanish, russian);
    }
}
