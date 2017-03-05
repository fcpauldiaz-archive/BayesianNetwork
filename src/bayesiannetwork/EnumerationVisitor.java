/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 4, 2017
**/

package bayesiannetwork;

import antlr4.BayesGrammarBaseVisitor;
import antlr4.BayesGrammarParser;
import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<String> hiddenVarsNum;
    private ArrayList<String> hiddenVarsDenom;
    
    public EnumerationVisitor() {
        this.hiddenVarsDenom = new ArrayList();
        this.hiddenVarsNum = new ArrayList();
    }
    
    @Override
    public Object visitCliBayes(BayesGrammarParser.CliBayesContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
            if (i == ctx.getChildCount() - 1) {
                if (joint)
                    System.out.println(newExpressionNum+"/"+newExpressionDenom);
                else
                    System.out.println(newExpressionNum);
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

    public String getNewExpressionNum() {
        return newExpressionNum;
    }


    public String getNewExpressionDenom() {
        return newExpressionDenom;
    }
    
    public void addHiddenNum(String s){
        this.hiddenVarsNum.add(s);
    }
    
    public void addHiddenDenom(String s){
        this.hiddenVarsDenom.add(s);
    }

    public ArrayList<String> getHiddenVarsNum() {
        return hiddenVarsNum;
    }

    public ArrayList<String> getHiddenVarsDenom() {
        return hiddenVarsDenom;
    }
    
    public void getHiddenVars(ArrayList<Node> network) {
        String[] vars = this.newExpressionNum.split(",");
        for (Node nodo : network) {
            boolean found = false;
            for (int j = 0; j < vars.length; j++) {
                String tmp = vars[j].replace("!", "");
                if (tmp.equals(nodo.getId())) {
                    found = true;
                }

            }
            if (found == false) {
                this.hiddenVarsNum.add(nodo.getId());
            }
        }

        vars = this.newExpressionDenom.split(",");
        for (Node nodo : network) {
            boolean found = false;
            for (int j = 0; j < vars.length; j++) {
                String tmp = vars[j].replace("!", "");
                if (tmp.equals(nodo.getId())) {
                    found = true;
                }

            }
            if (found == false) {
                this.hiddenVarsDenom.add(nodo.getId());
            }
        }
        System.out.println(this.hiddenVarsNum);
        if (this.newExpressionDenom.isEmpty()) {
            this.hiddenVarsDenom = new ArrayList();
        }
        System.out.println(this.hiddenVarsDenom);
       
    }
    
    public float enumerate(String expression, ArrayList<Node> network) {
        ArrayList<ArrayList<String>> pairs = new ArrayList();
        System.out.println("");
        float res1 = enumerateNum(expression, network);
        System.out.println(res1);
        System.out.println("");
        float res2 = enumerateDenom(expression, network);
        System.out.println(res2);
        return res1/res2;
    }
    
    public float enumerateNum(String expression, ArrayList<Node> completeNetwork) {
        float resultNum = 0;
        int n = this.hiddenVarsNum.size();
        for (int i = 0; i < Math.pow(2, n); i++) {
            String bin = Integer.toBinaryString(i);
            while (bin.length() < n)
                bin = "0" + bin;
            char[] chars = bin.toCharArray();
            String[] str = new String[n];
            for (int k = 0; k < this.hiddenVarsNum.size(); k++){
                for (int j = 0; j < chars.length; j++) {
                    if (j == k) {
                        if (chars[j] == '0'){
                            str[j] = this.hiddenVarsNum.get(k);
                        }
                        else{
                             str[j] = "!"+this.hiddenVarsNum.get(k);
                        }
                    }

                }
            }
            System.out.println(Arrays.toString(str));
            String newExpr = generateNewExpression(expression, new ArrayList(Arrays.asList(str)));  
            resultNum += this.evaluateExpression(newExpr, completeNetwork);
        }
        return resultNum;
    }
    public float enumerateDenom(String expression, ArrayList<Node> completeNetwork) {
        float resultDenom = 0;
        int n = this.hiddenVarsDenom.size();
        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < Math.pow(2, n); i++) {
            String bin = Integer.toBinaryString(i);
            while (bin.length() < n)
                bin = "0" + bin;
            char[] chars = bin.toCharArray();
            String[] str = new String[n];
            for (int k = 0; k < this.hiddenVarsDenom.size(); k++){
                for (int j = 0; j < chars.length; j++) {
                    if (j == k) {
                        if (chars[j] == '0'){
                            str[j] = this.hiddenVarsDenom.get(k);
                        }
                        else{
                             str[j] = "!"+this.hiddenVarsDenom.get(k);
                        }
                    }

                }
            }
            System.out.println(Arrays.toString(str));
            String newExpression = generateNewExpression(expression, new ArrayList(Arrays.asList(str)));
            resultDenom += this.evaluateExpression(newExpression, completeNetwork);
        }
        return resultDenom;
    }
    
    public String generateNewExpression(String expression, ArrayList<String> vars) {
        String expr = "";
        for (int j = 0; j < vars.size(); j++) {
            String str1 = vars.get(j);
            String str2 = str1;
            str2 = str2.replace("!", "");
            String[] splitter = expression.split(":");
            for (int i=0; i < splitter.length; i++){
                String splt = splitter[i];
                String newString = "";
                for (char ch: splt.toCharArray()) {
                    
                    if (ch == (str2.toCharArray()[0])) {
                        newString += str1;
                    }else{
                        newString += ch;
                    }
                }
                expr += newString+":";
                   
            }
            expression = expr; //iterate over same expression
            if (j != vars.size() - 1)
                expr = "";
        }
        return expr;
    }
    
    /**
     * Evaluates an string expression to the complete Bayesian Network
     * @param expression
     * @param completeNetwork
     * @return float with the evaluated expression
     */
    public float evaluateExpression(String expression, ArrayList<Node> completeNetwork) {
        String[] arrayExpr = expression.split(":");
        float prob = 1;
        for (int i = 0; i < arrayExpr.length;i++) {
            String expr = arrayExpr[i];
            if (!expr.isEmpty()) {
                for (Node node: completeNetwork) {
                    if (node.getExpression().equals(expr)) {
                        prob *= node.getProbability();
                    }
                }
            }
            
        }
        return prob;
    }
    
    
    

}
