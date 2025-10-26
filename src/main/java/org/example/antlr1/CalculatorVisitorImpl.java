package org.example.antlr1;

import org.example.antlr1.gen.CalculatorBaseVisitor;
import org.example.antlr1.gen.CalculatorParser;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double> {
    
    @Override
    public Double visitNumber(CalculatorParser.NumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().getText());
    }
    
    @Override
    public Double visitMulDiv(CalculatorParser.MulDivContext ctx) {
        double left = visit(ctx.expression(0));
        double right = visit(ctx.expression(1));
        
        if (ctx.op.getType() == CalculatorParser.T__0) {
            return left * right;
        } else {
            return left / right;
        }
    }
    
    @Override
    public Double visitAddSub(CalculatorParser.AddSubContext ctx) {
        double left = visit(ctx.expression(0));
        double right = visit(ctx.expression(1));
        
        if (ctx.op.getType() == CalculatorParser.T__2) {
            return left + right;
        } else {
            return left - right;
        }
    }
    
    @Override
    public Double visitParentheses(CalculatorParser.ParenthesesContext ctx) {
        return visit(ctx.expression());
    }
}