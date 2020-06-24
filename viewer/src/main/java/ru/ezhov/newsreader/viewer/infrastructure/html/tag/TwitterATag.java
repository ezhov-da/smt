package ru.ezhov.newsreader.viewer.infrastructure.html.tag;

class TwitterATag implements HtmlTag {
    private final String text;

    public TwitterATag(final String text) {
        this.text = text;
    }

    @Override
    public String html() {
        return "<a href=\"http://twitter.com/" + text + "\">" + text + "</a>";
    }
}
