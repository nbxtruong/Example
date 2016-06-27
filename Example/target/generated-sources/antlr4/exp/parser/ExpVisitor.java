// Generated from Exp.g4 by ANTLR 4.5.3

	package exp.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(ExpParser.ExpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStm(ExpParser.StmContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(ExpParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#exp1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp1(ExpParser.Exp1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ExpParser.FactorContext ctx);
}