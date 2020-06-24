package ru.ezhov.newsreader.viewer.infrastructure.html;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.ezhov.newsreader.core.feed.domain.EndIndex;
import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.ExpressionType;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.OriginalText;
import ru.ezhov.newsreader.core.feed.domain.Part;
import ru.ezhov.newsreader.core.feed.domain.StartIndex;
import ru.ezhov.newsreader.viewer.domain.View;

import java.util.Arrays;

class HtmlFeedViewerTest {
    @Test
    void shouldViewValidTextWithStartExpression() throws Exception {
        HtmlFeedViewer htmlFeedViewer = new HtmlFeedViewer();

        final View view = htmlFeedViewer.view(
                Feed.create(
                        OriginalText.create("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"),
                        Arrays.asList(
                                Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(0), EndIndex.create(4))),
                                Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(14), EndIndex.create(21))),
                                Expression.create(ExpressionType.LINK, Part.create(StartIndex.create(37), EndIndex.create(53))),
                                Expression.create(ExpressionType.TWITTER_USERNAME, Part.create(StartIndex.create(56), EndIndex.create(67)))
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

    @Test
    void shouldViewValidTextWithStartPlainText() throws Exception {
        HtmlFeedViewer htmlFeedViewer = new HtmlFeedViewer();

        final View view = htmlFeedViewer.view(
                Feed.create(
                        OriginalText.create("Visited Obama Facebook headquarters: http://bit.ly/xyz @elversatile"),
                        Arrays.asList(
                                Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(8), EndIndex.create(12))),
                                Expression.create(ExpressionType.ENTITY, Part.create(StartIndex.create(14), EndIndex.create(21))),
                                Expression.create(ExpressionType.LINK, Part.create(StartIndex.create(37), EndIndex.create(53))),
                                Expression.create(ExpressionType.TWITTER_USERNAME, Part.create(StartIndex.create(56), EndIndex.create(67)))
                        )
                )
        );

        assertThat(view.value()).isEqualTo(
                "Visited " +
                        "<strong>Obama</strong> " +
                        "<strong>Facebook</strong> " +
                        "headquarters: " +
                        "<a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> " +
                        "@<a href=\"http://twitter.com/elversatile\">elversatile</a>"
        );
    }
}