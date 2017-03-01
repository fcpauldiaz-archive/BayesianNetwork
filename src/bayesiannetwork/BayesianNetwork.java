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
import javax.swing.JOptionPane;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author SDX
 */
public class BayesianNetwork {


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File inputFile = new File("input.txt");
        FileManager manager = new FileManager();
        String in = "";

        in = manager.leerArchivo(inputFile);


        CharStream cs =  new ANTLRInputStream(in);

        BayesGrammarLexer lexer = new BayesGrammarLexer(cs);
        lexer.removeErrorListeners();

        CommonTokenStream tokens = new CommonTokenStream( lexer);
        BayesGrammarParser  parser = new BayesGrammarParser(tokens);
        BayesGrammarParser.ProgramContext contexto = parser.program();
        ParseTree tree = contexto;

            
        parser.removeErrorListeners();

        int errorsCount = parser.getNumberOfSyntaxErrors();
        System.out.println(errorsCount);
        if(errorsCount == 0){
            System.out.println("Parseo Exitoso");
            BayesVisitor vistor = new BayesVisitor();
            vistor.visit(tree);
        }
    }
    
}
