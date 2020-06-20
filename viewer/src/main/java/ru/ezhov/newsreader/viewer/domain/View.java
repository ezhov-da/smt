package ru.ezhov.newsreader.viewer.domain;

public class View {
    private final String value;

    public View(final String value) {
        this.value = value;
    }

    public static View create(final String value) throws ViewException {
        if (value == null) {
            throw new ViewException("Представление не может быть null");
        }
        return new View(value);
    }

    public String value() {
        return value;
    }
}
