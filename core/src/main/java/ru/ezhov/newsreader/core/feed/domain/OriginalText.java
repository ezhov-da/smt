package ru.ezhov.newsreader.core.feed.domain;

public class OriginalText {
    private final String value;

    public OriginalText(final String value) {
        this.value = value;
    }

    public static OriginalText create(final String value) throws FeedException {
        if (value == null || "".equals(value)) {
            throw new FeedException("Значение оригинального текста не может быть null или пусто");
        }
        return new OriginalText(value);
    }

    public String value() {
        return value;
    }
}
