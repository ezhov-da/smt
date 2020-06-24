package ru.ezhov.newsreader.core.feed.infrastructure;

import ru.ezhov.newsreader.core.feed.domain.EndIndex;
import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.ExpressionException;
import ru.ezhov.newsreader.core.feed.domain.ExpressionType;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.FeedException;
import ru.ezhov.newsreader.core.feed.domain.FeedParser;
import ru.ezhov.newsreader.core.feed.domain.FeedParserException;
import ru.ezhov.newsreader.core.feed.domain.OriginalText;
import ru.ezhov.newsreader.core.feed.domain.Part;
import ru.ezhov.newsreader.core.feed.domain.RawFeed;
import ru.ezhov.newsreader.core.feed.domain.StartIndex;

import java.util.ArrayList;
import java.util.List;

public class DefaultFeedParser implements FeedParser {
    @Override
    public Feed parse(final RawFeed rawFeed) throws FeedParserException {
        try {
            List<Expression> expressions = new ArrayList<>();
            expressions.add(Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(0), EndIndex.create(4))));
            expressions.add(Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(14), EndIndex.create(21))));
            expressions.add(Expression.create(ExpressionType.LINK, Part.create(StartIndex.create(37), EndIndex.create(53))));
            expressions.add(Expression.create(ExpressionType.TWITTER_USERNAME, Part.create(StartIndex.create(56), EndIndex.create(68))));
            return Feed.create(OriginalText.create(rawFeed.value()), expressions);
        } catch (ExpressionException e) {
            throw new FeedParserException("Ошибка в построении выражения", e);
        } catch (FeedException e) {
            throw new FeedParserException("Ошибка в построении Feed", e);
        }

    }
}
