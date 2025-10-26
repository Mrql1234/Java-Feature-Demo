// Generated from D:/IdeaProject/java-feature-demo/src/main/java/org/example/antlr2/BooleanExpression.g4 by ANTLR 4.13.2
package org.example.antlr2.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BooleanExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BooleanExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BooleanExpressionParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BooleanExpressionParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(BooleanExpressionParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(BooleanExpressionParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(BooleanExpressionParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(BooleanExpressionParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(BooleanExpressionParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(BooleanExpressionParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(BooleanExpressionParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(BooleanExpressionParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(BooleanExpressionParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(BooleanExpressionParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link BooleanExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(BooleanExpressionParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code explicitSet}
	 * labeled alternative in {@link BooleanExpressionParser#setExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSet(BooleanExpressionParser.ExplicitSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setVariable}
	 * labeled alternative in {@link BooleanExpressionParser#setExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariable(BooleanExpressionParser.SetVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanExpressionParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(BooleanExpressionParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(BooleanExpressionParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(BooleanExpressionParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link BooleanExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(BooleanExpressionParser.BooleanLiteralContext ctx);
}