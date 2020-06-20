package ru.ezhov.newsreader.viewer.domain;

import ru.ezhov.newsreader.core.feed.domain.Feed;

public interface FeedViewer {
    View view(Feed feed) throws FeedViewerException;
}
