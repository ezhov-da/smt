package ru.ezhov.newsreader.core.feed.domain;

public interface FeedParser {
    Feed parse(RawFeed rawFeed) throws FeedParserException;
}
