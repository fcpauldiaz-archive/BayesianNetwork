// Generated from /Users/SDX/NetBeansProjects/BayesianNetwork/src/antlr4/BayesGrammar.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BayesGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BayesGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(@NotNull BayesGrammarParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull BayesGrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(@NotNull BayesGrammarParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BayesGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BayesGrammarParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull BayesGrammarParser.OperatorContext ctx);
}