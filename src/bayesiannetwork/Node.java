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

    public Node(String id) {
        this.precedence = new ArrayList();
        this.id = id;
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
        return this.id.equals(node.getId());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", precedence=" + precedence + '}';
    }

   
    
    
  
    
}
