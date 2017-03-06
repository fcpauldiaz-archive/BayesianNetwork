/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesiannetwork;

import java.io.File;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import antlr4.BayesGrammarLexer;
import org.antlr.v4.runtime.CommonTokenStream;
import antlr4.BayesGrammarParser;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 *
 * @author SDX
 */
public class BayesianNetwork {

    public static int idNumber = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File inputFile = new File("input.txt");
        FileManager manager = new FileManager();
        String in;

        in = manager.leerArchivo(inputFile);

        //System.out.println(in);
        CharStream cs =  new ANTLRInputStream(in);

        BayesGrammarLexer lexer = new BayesGrammarLexer(cs);
        //lexer.removeErrorListeners();

        CommonTokenStream tokens = new CommonTokenStream( lexer);
        BayesGrammarParser  parser = new BayesGrammarParser(tokens);
        BayesGrammarParser.ProgramContext contexto = parser.program();
        ParseTree tree = contexto;

            

        int errorsCount = parser.getNumberOfSyntaxErrors();
        System.out.println(errorsCount);
        if(errorsCount == 0){
            System.out.println("Parseo Exitoso");
            BayesVisitor visitor = new BayesVisitor();
            visitor.visit(tree);
            BayesStructureVisitor structure = new BayesStructureVisitor();
            structure.visit(tree);
            String pTotal = structure.totalExpression();
            structure.completeTable();
            System.out.println(pTotal + " pTotal");
            System.out.println("");
            boolean valid = manager.getCantLines() == visitor.validateNetwork();
            System.out.println(visitor.getNetwork());
            GraphViz graph = new GraphViz(visitor.getNetwork());
            ArrayList<Node> network = visitor.getNetwork();
            ArrayList<Node> completeNetwork = structure.getStructure();
            if (valid) {
                while (true) {
                    System.out.println("");
                    System.out.println("Enter expression: ");
                    // Con caja de texto
                    String expression = JOptionPane.showInputDialog(
                       null,
                       "Expression to evaluate",
                       "",
                       JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
                    
                    
                    expression = expression.toUpperCase();
                    cs =  new ANTLRInputStream(expression);
                    lexer = new BayesGrammarLexer(cs);
                    tokens = new CommonTokenStream( lexer);
                    parser = new BayesGrammarParser(tokens);
                    BayesGrammarParser.CliBayesContext context = parser.cliBayes();
                    tree = context;
                    errorsCount = parser.getNumberOfSyntaxErrors();
                    if (errorsCount > 0) {
                        JOptionPane.showMessageDialog(null, "Expresión mal ingresada", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        EnumerationVisitor enumeration = new EnumerationVisitor();
                        enumeration.visit(tree);
                        enumeration.getHiddenVars(network);
                        pTotal = enumeration.includeExpression(pTotal, expression);
                        double answer = enumeration.enumerate(pTotal, completeNetwork);
                        JOptionPane.showMessageDialog(null, expression+" = "+answer);
                    
                    }
                }
            }
        }
    }
    
}
