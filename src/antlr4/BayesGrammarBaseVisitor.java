package antlr4;

// Generated from /Users/SDX/NetBeansProjects/BayesianNetwork/src/bayesiannetwork/antlr4/BayesGrammar.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link BayesGrammarVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class BayesGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements BayesGrammarVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProgram(@NotNull BayesGrammarParser.ProgramContext ctx) { return visitChildren(ctx); }
}