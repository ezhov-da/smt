package ru.ezhov.newsreader.viewer.infrastructure.html.tag;

class StrongTag implements HtmlTag {
    private final String text;

    public StrongTag(final String text) {
        this.text = text;
    }

    @Override
    public String html() {
        return "<strong>" + text + "</strong>";
    }
}
