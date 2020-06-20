package ru.ezhov.newsreader.core.feed.domain;

public class FeedParserException extends Exception {
    public FeedParserException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
