package ru.ezhov.newsreader.viewer.infrastructure.html.tag;

class SimpleATag implements HtmlTag {
    private final String hrefText;
    private final String body;

    public SimpleATag(final String hrefText, final String body) {
        this.hrefText = hrefText;
        this.body = body;
    }

    @Override
    public String html() {
        return "<a href=\"" + hrefText + "\">" + body + "</a>";
    }
}
