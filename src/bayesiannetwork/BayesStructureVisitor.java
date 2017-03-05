/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 4, 2017
**/

package bayesiannetwork;

import antlr4.BayesGrammarBaseVisitor;
import antlr4.BayesGrammarParser;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author SDX
 */
public class BayesStructureVisitor extends BayesGrammarBaseVisitor {
    
    private final ArrayList<Node> bayesStructure;
    private Node currentNode;
    
    public BayesStructureVisitor() {
        this.bayesStructure = new ArrayList();
    }

    @Override
    public Object visitOperator(BayesGrammarParser.OperatorContext ctx) {
        return super.visitOperator(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOperator2(BayesGrammarParser.Operator2Context ctx) {
        return super.visitOperator2(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object visitNegation(BayesGrammarParser.NegationContext ctx) {
        return super.visitNegation(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCondition(BayesGrammarParser.ConditionContext ctx) {
       // condition = true;
        return super.visitCondition(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOp(BayesGrammarParser.OpContext ctx) {
        return super.visitOp(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitProbability(BayesGrammarParser.ProbabilityContext ctx) {
        
      
            //this.visit(ctx.getChild(i));
            String expression = ctx.getText();
            //System.out.println(expression);
            float prob = Float.parseFloat(expression.substring(expression.indexOf("=") + 1, expression.length()).trim());
            currentNode = new Node(expression.substring(0, expression.indexOf("=")), prob);
            
            if (!this.bayesStructure.contains(currentNode))
                this.bayesStructure.add(currentNode);
            
        
        return null;
    }

    @Override
    public Object visitNumber(BayesGrammarParser.NumberContext ctx) {
        //currentNode.setProbability(Float.parseFloat(ctx.getText()));
        return super.visitNumber(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    @Override
    public Object visitProgram(BayesGrammarParser.ProgramContext ctx) {
        return super.visitProgram(ctx); //To change body of generated methods, choose Tools | Templates.
    }


    public void getStructure() {
        for (int i = 0; i < this.bayesStructure.size(); i++){
            System.out.println(this.bayesStructure.get(i).printNode());
        }
    } 
    

}
