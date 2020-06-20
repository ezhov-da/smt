package ru.ezhov.newsreader.core.feed.application;

public class FeedApplicationServiceException extends Exception {
    FeedApplicationServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
