package ru.ezhov.newsreader.core.feed.application;

import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.FeedParser;
import ru.ezhov.newsreader.core.feed.domain.FeedParserException;
import ru.ezhov.newsreader.core.feed.domain.RawFeed;
import ru.ezhov.newsreader.core.feed.domain.RawFeedException;

public class FeedApplicationService {
    private final FeedParser feedParser;

    public FeedApplicationService(final FeedParser feedParser) {
        this.feedParser = feedParser;
    }

    public Feed create(final String feed) throws FeedApplicationServiceException {
        try {
            return feedParser.parse(RawFeed.create(feed));
        } catch (FeedParserException e) {
            throw new FeedApplicationServiceException("Ошибка разбора входящего Feed", e);
        } catch (RawFeedException e) {
            throw new FeedApplicationServiceException("Ошибка во входных данных", e);
        }
    }
}
