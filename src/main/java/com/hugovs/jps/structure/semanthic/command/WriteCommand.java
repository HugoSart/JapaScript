package com.hugovs.jps.structure.semanthic.command;

import com.hugovs.jps.structure.semanthic.Expression;

public class WriteCommand extends Command {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
