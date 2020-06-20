package ru.ezhov.newsreader.core.feed.domain;

import java.util.Objects;

public class Expression {
    private final ExpressionType expressionType;
    private final String value;

    private Expression(final ExpressionType expressionType, final String value) {
        this.expressionType = expressionType;
        this.value = value;
    }

    public static Expression create(final ExpressionType expressionType, final String value) throws ExpressionException {
        if (expressionType == null || value == null || "".equals(value)) {
            throw new ExpressionException("Для создания выражения обязательны тип выражения и значение");
        }
        return new Expression(expressionType, value);
    }

    public ExpressionType type() {
        return expressionType;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return expressionType == that.expressionType &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionType, value);
    }

    @Override
    public String toString() {
        return value;
    }
}
