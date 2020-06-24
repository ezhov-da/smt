package ru.ezhov.newsreader.viewer.infrastructure.html.tag;

import ru.ezhov.newsreader.core.feed.domain.ExpressionType;

public abstract class HtmlTagFactory {
    public static HtmlTag by(final ExpressionType expressionType, final String value) {
        HtmlTag htmlTag;
        switch (expressionType) {
            case ENTITY:
                htmlTag = new StrongTag(value);
                break;
            case LINK:
                htmlTag = new SimpleATag(value, value);
                break;
            case TWITTER_USERNAME:
                htmlTag = new TwitterATag(value);
                break;
            default:
                htmlTag = new PlainTextTag(value);
        }
        return htmlTag;
    }
}
