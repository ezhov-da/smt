package ru.ezhov.newsreader.core.feed.domain;

import java.util.Objects;

public class Expression {
    private final ExpressionType expressionType;
    private final Part part;

    private Expression(final ExpressionType expressionType, final Part part) {
        this.expressionType = expressionType;
        this.part = part;
    }

    public static Expression create(final ExpressionType expressionType, final Part part) {
        return new Expression(expressionType, part);
    }

    public ExpressionType type() {
        return expressionType;
    }

    public Part position() {
        return part;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return expressionType == that.expressionType &&
                Objects.equals(part, that.part);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionType, part);
    }
}
