package org.example.antlr2;

import org.example.antlr2.gen.BooleanExpressionBaseVisitor;
import org.example.antlr2.gen.BooleanExpressionParser;

import java.util.*;
import java.math.BigDecimal;

// 值类型
interface Value {
    Object getValue();
}

class BooleanValue implements Value {
    private final boolean value;
    public BooleanValue(boolean value) { this.value = value; }
    @Override public Boolean getValue() { return value; }
}

class NumberValue implements Value {
    private final BigDecimal value;
    public NumberValue(BigDecimal value) { this.value = value; }
    public NumberValue(String value) { this.value = new BigDecimal(value); }
    @Override public BigDecimal getValue() { return value; }
}

class StringValue implements Value {
    private final String value;
    public StringValue(String value) { this.value = value; }
    @Override public String getValue() { return value; }
}

class SetValue implements Value {
    private final Set<Object> value;
    public SetValue(Set<Object> value) { this.value = value; }
    @Override public Set<Object> getValue() { return value; }
}

// 表达式求值访问器
public class BooleanExpressionVisitor extends BooleanExpressionBaseVisitor<Value> {
    private final Map<String, Value> variables;
    private final Map<String, Function> functions;
    
    public BooleanExpressionVisitor(Map<String, Value> variables) {
        this.variables = variables;
        this.functions = registerBuiltinFunctions();
    }
    
    private Map<String, Function> registerBuiltinFunctions() {
        Map<String, Function> funcs = new HashMap<>();
        
        // 数学函数
        funcs.put("abs", args -> {
            if (args.size() != 1) throw new RuntimeException("abs requires 1 argument");
            Value val = args.get(0);
            if (val instanceof NumberValue) {
                BigDecimal num = ((NumberValue) val).getValue();
                return new NumberValue(num.abs());
            }
            throw new RuntimeException("abs requires numeric argument");
        });
        
        funcs.put("min", args -> {
            if (args.size() < 1) throw new RuntimeException("min requires at least 1 argument");
            BigDecimal min = ((NumberValue) args.get(0)).getValue();
            for (Value arg : args) {
                BigDecimal current = ((NumberValue) arg).getValue();
                if (current.compareTo(min) < 0) min = current;
            }
            return new NumberValue(min);
        });
        
        funcs.put("max", args -> {
            if (args.size() < 1) throw new RuntimeException("max requires at least 1 argument");
            BigDecimal max = ((NumberValue) args.get(0)).getValue();
            for (Value arg : args) {
                BigDecimal current = ((NumberValue) arg).getValue();
                if (current.compareTo(max) > 0) max = current;
            }
            return new NumberValue(max);
        });
        
        // 集合函数
        funcs.put("size", args -> {
            if (args.size() != 1) throw new RuntimeException("size requires 1 argument");
            Value val = args.get(0);
            if (val instanceof SetValue) {
                int size = ((SetValue) val).getValue().size();
                return new NumberValue(new BigDecimal(size));
            }
            throw new RuntimeException("size requires set argument");
        });
        
        return funcs;
    }
    
    @Override
    public Value visitProgram(BooleanExpressionParser.ProgramContext ctx) {
        return visit(ctx.expression());
    }
    
    @Override
    public Value visitParenExpr(BooleanExpressionParser.ParenExprContext ctx) {
        return visit(ctx.expression());
    }
    
    @Override
    public Value visitNotExpr(BooleanExpressionParser.NotExprContext ctx) {
        Value value = visit(ctx.expression());
        if (value instanceof BooleanValue) {
            return new BooleanValue(!((BooleanValue) value).getValue());
        }
        throw new RuntimeException("NOT operator requires boolean operand");
    }
    
    @Override
    public Value visitAndExpr(BooleanExpressionParser.AndExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        
        if (left instanceof BooleanValue && right instanceof BooleanValue) {
            return new BooleanValue(
                ((BooleanValue) left).getValue() && 
                ((BooleanValue) right).getValue()
            );
        }
        throw new RuntimeException("AND operator requires boolean operands");
    }
    
    @Override
    public Value visitOrExpr(BooleanExpressionParser.OrExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        
        if (left instanceof BooleanValue && right instanceof BooleanValue) {
            return new BooleanValue(
                ((BooleanValue) left).getValue() || 
                ((BooleanValue) right).getValue()
            );
        }
        throw new RuntimeException("OR operator requires boolean operands");
    }
    
    @Override
    public Value visitCompareExpr(BooleanExpressionParser.CompareExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        String operator = ctx.getChild(1).getText();
        
        // 数值比较
        if (left instanceof NumberValue && right instanceof NumberValue) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            int cmp = leftNum.compareTo(rightNum);
            
            switch (operator) {
                case "<": return new BooleanValue(cmp < 0);
                case "<=": return new BooleanValue(cmp <= 0);
                case ">": return new BooleanValue(cmp > 0);
                case ">=": return new BooleanValue(cmp >= 0);
                case "==": return new BooleanValue(cmp == 0);
                case "!=": return new BooleanValue(cmp != 0);
            }
        }
        
        // 布尔比较
        if (left instanceof BooleanValue && right instanceof BooleanValue) {
            boolean leftBool = ((BooleanValue) left).getValue();
            boolean rightBool = ((BooleanValue) right).getValue();
            
            switch (operator) {
                case "==": return new BooleanValue(leftBool == rightBool);
                case "!=": return new BooleanValue(leftBool != rightBool);
            }
        }
        
        throw new RuntimeException("Comparison operator requires compatible types");
    }
    
    @Override
    public Value visitMulDivModExpr(BooleanExpressionParser.MulDivModExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        String operator = ctx.getChild(1).getText();
        
        if (left instanceof NumberValue && right instanceof NumberValue) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            
            switch (operator) {
                case "*": return new NumberValue(leftNum.multiply(rightNum));
                case "/": 
                    if (rightNum.compareTo(BigDecimal.ZERO) == 0) {
                        throw new RuntimeException("Division by zero");
                    }
                    return new NumberValue(leftNum.divide(rightNum, 10, BigDecimal.ROUND_HALF_UP));
                case "%": return new NumberValue(leftNum.remainder(rightNum));
            }
        }
        throw new RuntimeException("Arithmetic operators require numeric operands");
    }
    
    @Override
    public Value visitAddSubExpr(BooleanExpressionParser.AddSubExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));
        String operator = ctx.getChild(1).getText();
        
        if (left instanceof NumberValue && right instanceof NumberValue) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            
            switch (operator) {
                case "+": return new NumberValue(leftNum.add(rightNum));
                case "-": return new NumberValue(leftNum.subtract(rightNum));
            }
        }
        throw new RuntimeException("Add/Sub operators require numeric operands");
    }
    
    @Override
    public Value visitInExpr(BooleanExpressionParser.InExprContext ctx) {
        Value left = visit(ctx.expression());
        Value right = visit(ctx.setExpression());
        
        if (right instanceof SetValue) {
            Set<Object> set = ((SetValue) right).getValue();
            Object leftValue = extractValue(left);
            return new BooleanValue(set.contains(leftValue));
        }
        throw new RuntimeException("IN operator requires set as right operand");
    }
    
    @Override
    public Value visitFuncCallExpr(BooleanExpressionParser.FuncCallExprContext ctx) {
        return visit(ctx.functionCall());
    }
    
    @Override
    public Value visitFunctionCall(BooleanExpressionParser.FunctionCallContext ctx) {
        String funcName = ctx.ID().getText();
        List<Value> args = new ArrayList<>();
        
        if (ctx.expression() != null) {
            for (BooleanExpressionParser.ExpressionContext expr : ctx.expression()) {
                args.add(visit(expr));
            }
        }
        
        Function function = functions.get(funcName);
        if (function == null) {
            throw new RuntimeException("Unknown function: " + funcName);
        }
        
        return function.apply(args);
    }
    
    @Override
    public Value visitExplicitSet(BooleanExpressionParser.ExplicitSetContext ctx) {
        Set<Object> set = new HashSet<>();
        for (BooleanExpressionParser.ExpressionContext expr : ctx.expression()) {
            Value value = visit(expr);
            set.add(extractValue(value));
        }
        return new SetValue(set);
    }
    
    @Override
    public Value visitSetVariable(BooleanExpressionParser.SetVariableContext ctx) {
        String varName = ctx.ID().getText();
        Value value = variables.get(varName);
        if (value == null) {
            throw new RuntimeException("Unknown set variable: " + varName);
        }
        if (!(value instanceof SetValue)) {
            throw new RuntimeException("Variable " + varName + " is not a set");
        }
        return value;
    }
    
    @Override
    public Value visitIdExpr(BooleanExpressionParser.IdExprContext ctx) {
        String varName = ctx.ID().getText();
        Value value = variables.get(varName);
        if (value == null) {
            throw new RuntimeException("Unknown variable: " + varName);
        }
        return value;
    }
    
    @Override
    public Value visitNumberLiteral(BooleanExpressionParser.NumberLiteralContext ctx) {
        return new NumberValue(ctx.NUMBER().getText());
    }
    
    @Override
    public Value visitStringLiteral(BooleanExpressionParser.StringLiteralContext ctx) {
        String text = ctx.STRING().getText();
        return new StringValue(text.substring(1, text.length() - 1)); // Remove quotes
    }
    
    @Override
    public Value visitBooleanLiteral(BooleanExpressionParser.BooleanLiteralContext ctx) {
        return new BooleanValue(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
    }
    
    private Object extractValue(Value value) {
        if (value instanceof BooleanValue) return ((BooleanValue) value).getValue();
        if (value instanceof NumberValue) return ((NumberValue) value).getValue();
        if (value instanceof StringValue) return ((StringValue) value).getValue();
        throw new RuntimeException("Unsupported value type for set membership");
    }
    
    // 函数接口
    @FunctionalInterface
    interface Function {
        Value apply(List<Value> args);
    }
}