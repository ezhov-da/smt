package ru.ezhov.newsreader.viewer.infrastructure.html.tag;

public class PlainTextTag implements HtmlTag {
    private final String text;

    public PlainTextTag(final String text) {
        this.text = text;
    }

    @Override
    public String html() {
        return text;
    }
}
