package ru.ezhov.newsreader.viewer.infrastructure.html;

import ru.ezhov.newsreader.core.feed.domain.Expression;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.domain.OriginalText;
import ru.ezhov.newsreader.core.feed.domain.Part;
import ru.ezhov.newsreader.viewer.domain.FeedViewer;
import ru.ezhov.newsreader.viewer.domain.FeedViewerException;
import ru.ezhov.newsreader.viewer.domain.View;
import ru.ezhov.newsreader.viewer.domain.ViewException;
import ru.ezhov.newsreader.viewer.infrastructure.html.tag.HtmlTagFactory;

import java.util.List;

public class HtmlFeedViewer implements FeedViewer {

    @Override
    public View view(final Feed feed) throws FeedViewerException {
        try {
            View view;
            if (feed.expressions().isEmpty()) {
                view = View.create(feed.originalText().value());
            } else {
                view = createViewFromFeed(feed);
            }
            return view;
        } catch (ViewException e) {
            throw new FeedViewerException("Ошибка при построении представления Feed", e);
        }
    }

    private View createViewFromFeed(final Feed feed) throws ViewException {
        StringBuilder stringBuilder = new StringBuilder();
        final OriginalText originalText = feed.originalText();
        final String originalTextAsString = originalText.value();
        final List<Expression> expressions = feed.expressions();
        int currentPosition = 0;
        for (Expression expression : expressions) {
            final Part part = expression.position();
            String substring;
            if (part.startIndex().value() != currentPosition) {
                substring = substring(originalTextAsString, currentPosition, part.startIndex().value());
                stringBuilder.append(substring);
                currentPosition = part.startIndex().value();
            }
            substring = substring(originalTextAsString, currentPosition, part.endIndex().value() + 1);
            stringBuilder.append(HtmlTagFactory.by(expression.type(), substring).html());
            currentPosition = part.endIndex().value() + 1;
        }

        return View.create(stringBuilder.toString());
    }

    private String substring(String originalText, int beginIndex, int endIndex) {
        if (endIndex > originalText.length()) {
            return originalText.substring(beginIndex);
        } else {
            return originalText.substring(beginIndex, endIndex);
        }
    }
}