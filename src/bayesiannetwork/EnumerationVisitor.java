/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 4, 2017
**/

package bayesiannetwork;

import antlr4.BayesGrammarBaseVisitor;
import antlr4.BayesGrammarParser;

/**
 * STEPS
 * 1. WRITE QUERY IN JOINT PROBABILITY
 * 2. EXPAND EACH TERM AS P TOTAL.
 * 3. WRITE SUMMATORIES
 * 4. OPERATE ACCORDING TO STRUCTURE
 * 
 * 
 * @author SDX
 */
public class EnumerationVisitor extends BayesGrammarBaseVisitor {

    private boolean joint = false;
    private String newExpressionNum = "";
    private String newExpressionDenom = "";
    private int cantChild = 0;
    
    @Override
    public Object visitCliBayes(BayesGrammarParser.CliBayesContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
            if (i == ctx.getChildCount() - 1) {
                if (joint)
                    System.out.println(newExpressionNum+"/"+newExpressionDenom);
                else
                    System.out.println(newExpressionNum
                    );
                System.out.println();
                newExpressionNum = "";
                newExpressionDenom = "";
            }
        }
        return super.visitCliBayes(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitExpression(BayesGrammarParser.ExpressionContext ctx) {
        return super.visitExpression(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCondition(BayesGrammarParser.ConditionContext ctx) {
        //if parser enters here, then joint is not ready;
        //change using conditional rule
        joint = true;
        return super.visitCondition(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOperator(BayesGrammarParser.OperatorContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String child = ctx.getChild(i).getText();
            
            //System.out.println(child);
            newExpressionNum += child;     
            
        }
        return super.visitOperator(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOperator2(BayesGrammarParser.Operator2Context ctx) {
        return super.visitOperator2(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOp2(BayesGrammarParser.Op2Context ctx) {
        this.cantChild = ctx.getChildCount();
         for (int i = 0; i < ctx.getChildCount(); i++) {
            String child = ctx.getChild(i).getText();
            newExpressionDenom += child;
            if (child.contains(",")){
                child = child.replace(",", "");
            }
            newExpressionNum   += "," + child;          
           
         
            
        }
        return super.visitOp2(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    

}
