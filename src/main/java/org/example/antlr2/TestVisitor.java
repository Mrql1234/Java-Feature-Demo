package org.example.antlr2;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr2.gen.BooleanExpressionLexer;
import org.example.antlr2.gen.BooleanExpressionParser;

import java.util.*;

public class TestVisitor {
    public static void main(String[] args) {
        // 示例1: 简单布尔表达式
        String expression1 = "(age >= 18) && (hasLicense == true)";
        Map<String, Value> variables1 = new HashMap<>();
        variables1.put("age", new NumberValue("20"));
        variables1.put("hasLicense", new BooleanValue(true));

        Object result1 = evaluate(expression1, variables1);
        System.out.println(expression1 + " = " + result1);

        // 示例2: 包含算术运算
        String expression2 = "(score1 + score2) / 2 >= 60";
        Map<String, Value> variables2 = new HashMap<>();
        variables2.put("score1", new NumberValue("75"));
        variables2.put("score2", new NumberValue("85"));

        Object result2 = evaluate(expression2, variables2);
        System.out.println(expression2 + " = " + result2);

        // 示例3: 集合操作
        String expression3 = "department in validDepartments";
        Map<String, Value> variables3 = new HashMap<>();
        variables3.put("department", new StringValue("Engineering"));
        Set<Object> departments = new HashSet<>(Arrays.asList("Engineering", "Sales", "Marketing"));
        variables3.put("validDepartments", new SetValue(departments));

        Object result3 = evaluate(expression3, variables3);
        System.out.println(expression3 + " = " + result3);

        // 示例4: 函数调用
        String expression4 = "max(score1, score2, score3) > 90";
        Map<String, Value> variables4 = new HashMap<>();
        variables4.put("score1", new NumberValue("85"));
        variables4.put("score2", new NumberValue("92"));
        variables4.put("score3", new NumberValue("88"));

        Object result4 = evaluate(expression4, variables4);
        System.out.println(expression4 + " = " + result4);

        // 示例5: 复杂表达式
        String expression5 = "(age >= 18 && income > 50000) || (hasCosigner == true)";
        Map<String, Value> variables5 = new HashMap<>();
        variables5.put("age", new NumberValue("25"));
        variables5.put("income", new NumberValue("45000"));
        variables5.put("hasCosigner", new BooleanValue(true));

        Object result5 = evaluate(expression5, variables5);
        System.out.println(expression5 + " = " + result5);
    }

    public static Object evaluate(String expression, Map<String, Value> variables) {
        try {
            CharStream input = CharStreams.fromString(expression);
            BooleanExpressionLexer lexer = new BooleanExpressionLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BooleanExpressionParser parser = new BooleanExpressionParser(tokens);

            ParseTree tree = parser.program();
            BooleanExpressionVisitor evaluator = new BooleanExpressionVisitor(variables);
            Value result = evaluator.visit(tree);

            return extractPrimitiveValue(result);
        } catch (Exception e) {
            throw new RuntimeException("Evaluation error: " + e.getMessage(), e);
        }
    }

    private static Object extractPrimitiveValue(Value value) {
        if (value instanceof BooleanValue) return ((BooleanValue) value).getValue();
        if (value instanceof NumberValue) return ((NumberValue) value).getValue();
        if (value instanceof StringValue) return ((StringValue) value).getValue();
        if (value instanceof SetValue) return ((SetValue) value).getValue();
        throw new RuntimeException("Unknown value type");
    }
}
