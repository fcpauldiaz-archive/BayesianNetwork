/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 1, 2017
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
public class BayesVisitor extends BayesGrammarBaseVisitor {
    
    private HashSet<String> vars;
    private boolean condition = false;
    private ArrayList<Node> bayesNetwork;
    private String currentId;
    private Node currentNode;
    
    public BayesVisitor() {
        this.vars = new HashSet();
        this.bayesNetwork = new ArrayList();
    }

    @Override
    public Object visitOperator(BayesGrammarParser.OperatorContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String child = ctx.getChild(i).getText();
            if (!child.equals(",") && !child.equals("!")) {
                //System.out.println(child);
                    currentNode = new Node(child);
                    currentId = child;
                    if (!this.bayesNetwork.contains(currentNode))
                        this.bayesNetwork.add(currentNode);
            }
        }
        return super.visitOperator(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOperator2(BayesGrammarParser.Operator2Context ctx) {
            for (int i = 0; i < ctx.getChildCount(); i++){
            String child = ctx.getChild(i).getText();
            if (!child.equals(",") && !child.equals("!")) {
               // System.out.println(child);
              
                if (condition) {
                    Node search = this.searchNode(child);
                    
                    currentNode.addNode(search);
                    //System.out.println("entra");
                    //System.out.println(child);
                } else {
                    currentId = child;
                }
                
               
                
            }
           
            
        }
        return super.visitOperator2(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object visitNegation(BayesGrammarParser.NegationContext ctx) {
        return super.visitNegation(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCondition(BayesGrammarParser.ConditionContext ctx) {
        condition = true;
        return super.visitCondition(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitOp(BayesGrammarParser.OpContext ctx) {
        return super.visitOp(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitProbability(BayesGrammarParser.ProbabilityContext ctx) {
        
        for (int i = 0; i < ctx.getChildCount(); i++){
            this.visit(ctx.getChild(i));
            if (i == ctx.getChildCount() -1 ) {
                if (!this.bayesNetwork.contains(currentNode))
                    this.bayesNetwork.add(currentNode);
            }
        }
        condition = false;
        return null;
    }

    @Override
    public Object visitNumber(BayesGrammarParser.NumberContext ctx) {
        //currentNode.setProbability(Double.parseDouble(ctx.getText()));
        return super.visitNumber(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Node searchNode(String id){
        for (Node bayesNetwork1 : this.bayesNetwork) {
            if (bayesNetwork1.getId().equals(id)) {
                return bayesNetwork1;
            }
        }
        return null;
    }

    @Override
    public Object visitProgram(BayesGrammarParser.ProgramContext ctx) {
        return super.visitProgram(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    public HashSet<String> getVars() {
        return vars;
    }

    public void setVars(HashSet<String> vars) {
        this.vars = vars;
    }

    public ArrayList<Node> getNetwork() {
        return bayesNetwork;
    }
    
    public int validateNetwork() {
        int cant = 0;
        for (int i = 0; i < this.bayesNetwork.size(); i++) {
            Node node = this.bayesNetwork.get(i);
            int cantPrecedence = node.getList().size();
            cantPrecedence = (int)Math.pow(2, cantPrecedence);
            cant += cantPrecedence;
            
        }
        return cant;
    }
    

}
