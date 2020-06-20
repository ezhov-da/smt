package ru.ezhov.newsreader.core.feed.infrastructure;

import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.ExpressionException;
import ru.ezhov.newsreader.core.feed.domain.ExpressionType;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.FeedException;
import ru.ezhov.newsreader.core.feed.domain.FeedParser;
import ru.ezhov.newsreader.core.feed.domain.FeedParserException;
import ru.ezhov.newsreader.core.feed.domain.RawFeed;

import java.util.ArrayList;
import java.util.List;

public class DefaultFeedParser implements FeedParser {
    @Override
    public Feed parse(final RawFeed rawFeed) throws FeedParserException {
        try {
            final String value = rawFeed.value();
            List<Expression> expressions = new ArrayList<>();
            expressions.add(Expression.create(ExpressionType.ENTITY, value.substring(0, 5)));
            expressions.add(Expression.create(ExpressionType.PLAIN_TEXT, value.substring(6, 13)));
            expressions.add(Expression.create(ExpressionType.ENTITY, value.substring(14, 22)));
            expressions.add(Expression.create(ExpressionType.PLAIN_TEXT, value.substring(23, 36)));
            expressions.add(Expression.create(ExpressionType.LINK, value.substring(37, 54)));
            expressions.add(Expression.create(ExpressionType.TWITTER_USERNAME, value.substring(56, 67)));
            return Feed.create(expressions);
        } catch (ExpressionException e) {
            throw new FeedParserException("Ошибка в построении выражения", e);
        } catch (FeedException e) {
            throw new FeedParserException("Ошибка в построении Feed", e);
        }

    }
}
