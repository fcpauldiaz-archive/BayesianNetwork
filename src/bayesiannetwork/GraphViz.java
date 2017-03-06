/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 5, 2017
**/

package bayesiannetwork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author SDX
 */
public class GraphViz {
    
    public GraphViz(ArrayList<Node> simpleNetwork) {
        createGraph("bayes", simpleNetwork);
    }
    
    private void createGraph(String nombreArchivo, ArrayList<Node> simpleNetwork) {
        
        String texto = "digraph nodo_bayesiano {\n";

        texto +="\trankdir=LR;"+"\n";
        
        texto += "\tgraph [label=\""+nombreArchivo+"\", labelloc=t, fontsize=20]; \n";
        texto +="\tnode [shape=doublecircle, style = filled,color = mediumseagreen];";
        //listar estados de aceptación
        //for(int i=0;i<automataFinito.getEstadosAceptacion().size();i++){
            //texto+=" "+automataFinito.getEstadosAceptacion().get(i);
        //}
        //
        texto+="\n";
        texto +="\tnode [shape=circle];"+"\n";
        texto +="\tnode [color=midnightblue,fontcolor=white];\n" +"	edge [color=red];"+"\n";
       
        //texto +="\tsecret_node [style=invis];\n" + "	secret_node -> "+automataFinito.getEstadoInicial()+" [label=\"inicio\"];" + "\n";
	//transiciones
        for(int i=0;i < simpleNetwork.size();i++){
            Node node = simpleNetwork.get(i);
            ArrayList<Node> destination = this.searchNodes(node.getId(), simpleNetwork);
            for  (int j = 0; j < destination.size(); j++) {
               Node dest = destination.get(j);
               texto += "\t" + node.getId() + " -> " + dest.getId() + "\n";
           }
            
        }
        texto+="}";
        
        File dummy = new File("");
        String path = dummy.getAbsolutePath();
        path+="/";
        String archivo =nombreArchivo+".dot";
        new File(path+"/GeneracionAutomatas/").mkdirs();
        new File(path+"/GeneracionAutomatas/PNG").mkdirs();
        new File(path+"/GeneracionAutomatas/DOT").mkdirs();
        String pathImagen = path+"GeneracionAutomatas/PNG/";
        path+="GeneracionAutomatas/DOT/";
        File TextFile = new File("/GeneracionAutomatas/DOT/"+nombreArchivo+".dot");
        FileWriter TextOut;
    
        try {
            TextOut = new FileWriter(path+nombreArchivo+".dot");
            TextOut.write(texto);
           
            TextOut.close();
        } catch (IOException ex) {
          
        }
        String comando = "dot -Tpng "+path+archivo + " > "+pathImagen+nombreArchivo+".png";
        System.out.println(pathImagen+nombreArchivo);
        System.out.println(path+archivo);
        try
        {
            ProcessBuilder pbuilder;

            /*
             * Realiza la construccion del comando    
             * en la linea de comandos esto es: 
             * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder( "/usr/local/bin/dot", "-Tpng", "-o",pathImagen+nombreArchivo+".png",path+archivo );
            pbuilder.redirectErrorStream( true );
            //Ejecuta el proceso
            pbuilder.start();
        }
        catch (IOException e) {
            e.printStackTrace();

           /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
        }
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); 
        panel.setSize(500,640);
        frame.setSize(500, 600);
        ImageIcon icon = new ImageIcon(pathImagen+nombreArchivo+".png"); 
        JLabel label = new JLabel(); 
        label.setIcon(icon); 
        panel.add(label);
        frame.add(panel); 
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
    
    public ArrayList<Node> searchNodes(String id, ArrayList<Node> network) {
        ArrayList<Node> destination = new ArrayList();
        for (int i = 0; i < network.size(); i++) {
            Node node = network.get(i);
            ArrayList<Node> prec = node.getPrecedence();
            for (int j = 0; j < prec.size(); j++) {
                Node actualNode = prec.get(j);
                if (actualNode.getId().equals(id)) {
                    destination.add(node);
                }
            }
        }
        return destination;
    }

}
