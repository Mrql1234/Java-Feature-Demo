// Generated from D:/IdeaProject/java-feature-demo/src/main/java/org/example/antlr2/BooleanExpression.g4 by ANTLR 4.13.2
package org.example.antlr2.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BooleanExpressionParser}.
 */
public interface BooleanExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BooleanExpressionParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BooleanExpressionParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanExpressionParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BooleanExpressionParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(BooleanExpressionParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(BooleanExpressionParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(BooleanExpressionParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(BooleanExpressionParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(BooleanExpressionParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(BooleanExpressionParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(BooleanExpressionParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(BooleanExpressionParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(BooleanExpressionParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(BooleanExpressionParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(BooleanExpressionParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(BooleanExpressionParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(BooleanExpressionParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(BooleanExpressionParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(BooleanExpressionParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(BooleanExpressionParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(BooleanExpressionParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(BooleanExpressionParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(BooleanExpressionParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(BooleanExpressionParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(BooleanExpressionParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(BooleanExpressionParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code explicitSet}
	 * labeled alternative in {@link BooleanExpressionParser#setExpression}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSet(BooleanExpressionParser.ExplicitSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code explicitSet}
	 * labeled alternative in {@link BooleanExpressionParser#setExpression}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSet(BooleanExpressionParser.ExplicitSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setVariable}
	 * labeled alternative in {@link BooleanExpressionParser#setExpression}.
	 * @param ctx the parse tree
	 */
	void enterSetVariable(BooleanExpressionParser.SetVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setVariable}
	 * labeled alternative in {@link BooleanExpressionParser#setExpression}.
	 * @param ctx the parse tree
	 */
	void exitSetVariable(BooleanExpressionParser.SetVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanExpressionParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BooleanExpressionParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanExpressionParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BooleanExpressionParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(BooleanExpressionParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(BooleanExpressionParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(BooleanExpressionParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(BooleanExpressionParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(BooleanExpressionParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(BooleanExpressionParser.BooleanLiteralContext ctx);
}