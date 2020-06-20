package ru.ezhov.newsreader.core.feed.domain;

import java.util.Collections;
import java.util.List;

public class Feed {
    private final List<Expression> expressions;

    public Feed(final List<Expression> expressions) {
        this.expressions = expressions;
    }

    public static Feed create(final List<Expression> expressions) throws FeedException {
        if (expressions == null || expressions.isEmpty()) {
            throw new FeedException("Feed не может быть пустым");
        }
        return new Feed(Collections.unmodifiableList(expressions));
    }

    public List<Expression> expressions() {
        return expressions;
    }
}
