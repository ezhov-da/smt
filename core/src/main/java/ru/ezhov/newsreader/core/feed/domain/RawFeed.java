package ru.ezhov.newsreader.core.feed.domain;

public class RawFeed {
    private final String value;

    private RawFeed(final String value) {
        this.value = value;
    }

    public static RawFeed create(final String value) throws RawFeedException {
        if (value == null || "".equals(value)) {
            throw new RawFeedException("Оригинальные данные не могут быть null или пустыми");
        }
        return new RawFeed(value);
    }

    public String value() {
        return value;
    }
}
