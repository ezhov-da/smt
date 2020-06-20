package ru.ezhov.newsreader.viewer.infrastructure.html;

import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.viewer.domain.FeedViewer;
import ru.ezhov.newsreader.viewer.domain.FeedViewerException;
import ru.ezhov.newsreader.viewer.domain.View;
import ru.ezhov.newsreader.viewer.domain.ViewException;
import ru.ezhov.newsreader.viewer.infrastructure.html.tag.HtmlTag;
import ru.ezhov.newsreader.viewer.infrastructure.html.tag.HtmlTagFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HtmlFeedViewer implements FeedViewer {

    @Override
    public View view(final Feed feed) throws FeedViewerException {
        final List<Expression> expressions = feed.expressions();

        try {
            return View.create(
                    expressions
                            .stream()
                            .map(HtmlTagFactory::by)
                            .map(HtmlTag::html)
                            .collect(Collectors.joining(" "))
            );
        } catch (ViewException e) {
            throw new FeedViewerException("Ошибка при построении представления Feed", e);
        }
    }
}
