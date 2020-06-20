package ru.ezhov.newsreader.core.feed.domain;

public class FeedException extends Exception {
    FeedException(final String message) {
        super(message);
    }
}
