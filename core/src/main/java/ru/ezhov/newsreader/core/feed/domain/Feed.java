package ru.ezhov.newsreader.core.feed.domain;

import java.util.Collections;
import java.util.List;

public class Feed {
    private final OriginalText originalText;
    private final List<Expression> expressions;

    public Feed(final OriginalText originalText, final List<Expression> expressions) {
        this.originalText = originalText;
        this.expressions = expressions;

    }

    public static Feed create(final OriginalText originalText, final List<Expression> expressions) throws FeedException {
        if (expressions == null || expressions.isEmpty()) {
            throw new FeedException("Feed не может быть пустым");
        }
        return new Feed(originalText, Collections.unmodifiableList(expressions));
    }

    public OriginalText originalText() {
        return originalText;
    }

    public List<Expression> expressions() {
        return expressions;
    }
}
