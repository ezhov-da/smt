package ru.ezhov.newsreader.core.feed.infrastructure;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.ExpressionType;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.RawFeed;

import java.util.List;

public class DefaultFeedParserTest {
    @Test
    void shouldParseDefaultText() throws Exception {
        DefaultFeedParser defaultFeedParser = new DefaultFeedParser();

        final Feed feed = defaultFeedParser.parse(RawFeed.create("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"));

        final List<Expression> expressions = feed.expressions();
        assertThat(expressions)
                .containsSequence(
                        Expression.create(ExpressionType.ENTITY, "Obama"),
                        Expression.create(ExpressionType.PLAIN_TEXT, "visited"),
                        Expression.create(ExpressionType.ENTITY, "Facebook"),
                        Expression.create(ExpressionType.PLAIN_TEXT, "headquarters:"),
                        Expression.create(ExpressionType.LINK, "http://bit.ly/xyz"),
                        Expression.create(ExpressionType.TWITTER_USERNAME, "elversatile")
                );
    }
}