/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 4, 2017
**/

package bayesiannetwork;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author SDX
 */
public class Node  {

    private String id;
    private ArrayList<Node> precedence;
    private float probability;
    private String expression;

    public Node(String id) {
        this.precedence = new ArrayList();
        this.id = id;
    }

    public Node( String expression, float probability) {
        this.probability = probability;
        this.expression = expression;
    }

    
    public String getId() {
        return id;
    }
    
    
    public void addNode(Node a){
        this.precedence.add(a);
    }
    
    public ArrayList<Node> getList() {
        return this.precedence;
    }

    public ArrayList<Node> getPrecedence() {
        return precedence;
    }
        
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Node node = (Node)o;
        if (this.expression == null || node.getExpression() == null) {
            return this.id.equals(node.getId());
        }
        if (this.id == null ) {
            return this.expression.equals(node.getExpression());
        }
        return this.id.equals(node.getId()); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String printNode() {
        return "Node{" + "probability=" + probability + ", expression=" + expression + '}';
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", precedence=" + precedence + '}';
    }

  
    

    
    

    
   
    
    
  
    
}
