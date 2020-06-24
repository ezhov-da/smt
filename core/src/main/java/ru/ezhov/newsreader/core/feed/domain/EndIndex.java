package ru.ezhov.newsreader.core.feed.domain;

import java.util.Objects;

public class EndIndex {
    private final int value;

    private EndIndex(final int value) {
        this.value = value;
    }

    public static EndIndex create(final int value) throws ExpressionException {
        if (value < 0) {
            throw new ExpressionException("Конечный индекс не может быть меньше нуля");
        }
        return new EndIndex(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndIndex endIndex = (EndIndex) o;
        return value == endIndex.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}