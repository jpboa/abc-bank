package com.abc;

import java.util.function.Consumer;

class StatementCollector implements Consumer<Statement> {

    private Statement statement;

    public StatementCollector() {
        statement = new Statement("", 0.0);
    }

    @Override
    public void accept(Statement t) {
        statement.setText(statement.getText() + t.getText());
        statement.setTotal(statement.getTotal() + t.getTotal());
    }

    public Statement getStatement() {
        return statement;
    }

    public void combine(StatementCollector other) {
        statement.setText(statement.getText() + other.statement.getText());
        statement.setTotal(statement.getTotal() + other.statement.getTotal());
    }
}