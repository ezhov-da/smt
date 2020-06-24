package ru.ezhov.newsreader.core.feed.domain;

import java.util.Objects;

public class StartIndex {
    private final int value;

    private StartIndex(final int value) {
        this.value = value;
    }

    public static StartIndex create(final int value) throws ExpressionException {
        if (value < 0) {
            throw new ExpressionException("Начальный индекс не может быть меньше нуля");
        }
        return new StartIndex(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartIndex that = (StartIndex) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
