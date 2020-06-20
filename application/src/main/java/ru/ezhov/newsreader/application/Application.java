package ru.ezhov.newsreader.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ezhov.newsreader.core.feed.application.FeedApplicationService;
import ru.ezhov.newsreader.core.feed.application.FeedApplicationServiceException;
import ru.ezhov.newsreader.core.feed.domain.Feed;
import ru.ezhov.newsreader.core.feed.infrastructure.DefaultFeedParser;
import ru.ezhov.newsreader.viewer.domain.FeedViewer;
import ru.ezhov.newsreader.viewer.domain.FeedViewerException;
import ru.ezhov.newsreader.viewer.domain.View;
import ru.ezhov.newsreader.viewer.infrastructure.html.HtmlFeedViewer;

public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        try {
            FeedApplicationService feedApplicationService = new FeedApplicationService(new DefaultFeedParser());
            final Feed feed = feedApplicationService.create("Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile");

            FeedViewer feedViewer = new HtmlFeedViewer();
            final View view = feedViewer.view(feed);

            System.out.println(view.value());
        } catch (FeedApplicationServiceException e) {
            LOG.error("Ошибка при получении Feed", e);
        } catch (FeedViewerException e) {
            LOG.error("Ошибка при при построении представления Feed", e);
        }
    }
}