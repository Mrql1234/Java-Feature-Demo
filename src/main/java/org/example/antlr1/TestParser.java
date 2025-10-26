package org.example.antlr1;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr1.gen.CalculatorLexer;
import org.example.antlr1.gen.CalculatorParser;

public class TestParser {
    public static void main(String[] args) {
        // 输入表达式
        String input = "( (2 + 3 ) * 4)";

        // 创建词法分析器
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(input));

        // 创建词法符号流
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 创建语法分析器
        CalculatorParser parser = new CalculatorParser(tokens);

        // 解析表达式
        ParseTree tree = parser.expression();

        // 创建计算器访问器
        CalculatorVisitorImpl visitor = new CalculatorVisitorImpl();

        // 计算结果
        double result = visitor.visit(tree);
        System.out.println("Result: " + result);
    }
}
