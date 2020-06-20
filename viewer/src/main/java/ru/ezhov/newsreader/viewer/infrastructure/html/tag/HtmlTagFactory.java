package ru.ezhov.newsreader.viewer.infrastructure.html.tag;

import ru.ezhov.newsreader.core.feed.domain.Expression;

public abstract class HtmlTagFactory {
    public static HtmlTag by(final Expression expression) {
        HtmlTag htmlTag;
        switch (expression.type()) {
            case ENTITY:
                htmlTag = new StrongTag(expression.value());
                break;
            case LINK:
                htmlTag = new SimpleATag(expression.value(), expression.value());
                break;
            case TWITTER_USERNAME:
                htmlTag = new TwitterATag(expression.value());
                break;
            default:
                htmlTag = new PlainTextTag(expression.value());
        }
        return htmlTag;
    }
}
