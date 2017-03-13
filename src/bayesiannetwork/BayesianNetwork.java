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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.antlr.v4.runtime.tree.ParseTree;
import terminal.Console;
import terminal.DefaultCompletionSource;
import terminal.InputProcessor;
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
            boolean validR = visitor.validateUnique(in);
            System.out.println(visitor.getNetwork());
            GraphViz graphViz = new GraphViz(visitor.getNetwork());
            ArrayList<Node> network = visitor.getNetwork();
            ArrayList<Node> completeNetwork = structure.getStructure();
            if (valid && validR) {
                JFrame frame = new JFrame("Console Demo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);

                Console console = new Console(Color.BLACK, Color.GREEN, 
                                new Font(Font.MONOSPACED, Font.BOLD, 14), "$ ");
                console.setPreferredSize(new Dimension(800, 600));

                console.setCompletionSource(new DefaultCompletionSource("help", "list", "die", "dinosaurs"));
                console.setProcessor(new InputProcessor() {
                    public void process(String expression, Console console)
                    {
                        System.out.println("You typed: '" + expression + "'");
                            
                        expression = expression.toUpperCase();
                        CharStream cs =  new ANTLRInputStream(expression);
                        BayesGrammarLexer lexer = new BayesGrammarLexer(cs);
                        CommonTokenStream tokens = new CommonTokenStream( lexer);
                        BayesGrammarParser parser = new BayesGrammarParser(tokens);
                        BayesGrammarParser.CliBayesContext context = parser.cliBayes();
                        ParseTree tree = context;
                        int errorsCount = parser.getNumberOfSyntaxErrors();
                        if (errorsCount > 0) {
                            JOptionPane.showMessageDialog(null, "Expresión mal ingresada", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            EnumerationVisitor enumeration = new EnumerationVisitor();
                            enumeration.visit(tree);
                            boolean validVars = enumeration.validateExpression(visitor.getNetwork());
                            if (!validVars) {
                                JOptionPane.showMessageDialog(null, "Hay una variable no existente", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                enumeration.getHiddenVars(network);
                               // pTotal = enumeration.includeExpression(pTotal, expression);
                                double answer = enumeration.enumerate(pTotal, completeNetwork, visitor.getNetwork());
                               // JOptionPane.showMessageDialog(null, expression+" = "+answer);
                                console.write("> " + answer + "\n");
                            }

                        }
                            
                            
                            
                    }

                });
                frame.add(console);

                frame.pack();
                frame.setVisible(true);
                /*while (true) {
                    try {
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
                            boolean validVars = enumeration.validateExpression(visitor.getNetwork());
                            if (!validVars) {
                                JOptionPane.showMessageDialog(null, "Hay una variable no existente", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                enumeration.getHiddenVars(network);
                               // pTotal = enumeration.includeExpression(pTotal, expression);
                                double answer = enumeration.enumerate(pTotal, completeNetwork, visitor.getNetwork());
                                JOptionPane.showMessageDialog(null, expression+" = "+answer);
                            }

                        }
                    } catch(Exception e) {
                        break;
                    }
                }*/
            }
            else {
               JOptionPane.showMessageDialog(null, "Error: not valid","",  JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
}
