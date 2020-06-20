package ru.ezhov.newsreader.viewer.infrastructure.html;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.ExpressionType;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.viewer.domain.View;

import java.util.Arrays;

class HtmlFeedViewerTest {
    @Test
    void shouldViewValidText() throws Exception {
        HtmlFeedViewer htmlFeedViewer = new HtmlFeedViewer();

        final View view = htmlFeedViewer.view(
                Feed.create(
                        Arrays.asList(
                                Expression.create(ExpressionType.ENTITY, "Obama"),
                                Expression.create(ExpressionType.PLAIN_TEXT, "visited"),
                                Expression.create(ExpressionType.ENTITY, "Facebook"),
                                Expression.create(ExpressionType.PLAIN_TEXT, "headquarters:"),
                                Expression.create(ExpressionType.LINK, "http://bit.ly/xyz"),
                                Expression.create(ExpressionType.TWITTER_USERNAME, "elversatile")
                        )
                )
        );

        assertThat(view.value()).isEqualTo(
                "<strong>Obama</strong> " +
                        "visited " +
                        "<strong>Facebook</strong> " +
                        "headquarters: " +
                        "<a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> " +
                        "@<a href=\"http://twitter.com/elversatile\">elversatile</a>"
        );
    }
}