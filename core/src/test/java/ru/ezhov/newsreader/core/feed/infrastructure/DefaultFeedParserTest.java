package ru.ezhov.newsreader.core.feed.infrastructure;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.ezhov.newsreader.core.feed.domain.EndIndex;
import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.ExpressionType;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.Part;
import ru.ezhov.newsreader.core.feed.domain.RawFeed;
import ru.ezhov.newsreader.core.feed.domain.StartIndex;

import java.util.List;

public class DefaultFeedParserTest {
    @Test
    void shouldParseDefaultText() throws Exception {
        DefaultFeedParser defaultFeedParser = new DefaultFeedParser();

        final Feed feed = defaultFeedParser.parse(RawFeed.create("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"));

        final List<Expression> expressions = feed.expressions();
        assertThat(expressions)
                .containsSequence(
                        Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(0), EndIndex.create(4))),
                        Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(14), EndIndex.create(21))),
                        Expression.create(ExpressionType.LINK, Part.create(StartIndex.create(37), EndIndex.create(53))),
                        Expression.create(ExpressionType.TWITTER_USERNAME, Part.create(StartIndex.create(56), EndIndex.create(68)))
                );
    }
}