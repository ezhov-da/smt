package ru.ezhov.newsreader.core.feed.domain;

import java.util.Objects;

public class Part {
    private final StartIndex startIndex;
    private final EndIndex endIndex;

    private Part(StartIndex startIndex, EndIndex endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static Part create(StartIndex startIndex, EndIndex endIndex) throws ExpressionException {
        if (endIndex.value() < startIndex.value()) {
            throw new ExpressionException("Конечный индекс '" + endIndex.value() + "' не можеть быть меньше начального '" + startIndex.value() + "'");
        }
        return new Part(startIndex, endIndex);
    }

    public StartIndex startIndex() {
        return startIndex;
    }

    public EndIndex endIndex() {
        return endIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Objects.equals(startIndex, part.startIndex) &&
                Objects.equals(endIndex, part.endIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIndex, endIndex);
    }
}
