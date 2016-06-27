// Generated from Exp.g4 by ANTLR 4.5.3

	package exp.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(ExpParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(ExpParser.ExpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterStm(ExpParser.StmContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitStm(ExpParser.StmContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(ExpParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(ExpParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#exp1}.
	 * @param ctx the parse tree
	 */
	void enterExp1(ExpParser.Exp1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#exp1}.
	 * @param ctx the parse tree
	 */
	void exitExp1(ExpParser.Exp1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExpParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExpParser.FactorContext ctx);
}