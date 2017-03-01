/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Mar 1, 2017
**/

package bayesiannetwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author SDX
 */
public class FileManager {
    
     
    public String leerArchivo(File inputFile){
      
        int contador=0;
        int tamaño=0;
        String input=" ";
        BufferedReader br = null;
 
        try {

                String sCurrentLine;
                
                br = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));

               
               
               while ((sCurrentLine = br.readLine()) != null) {
                    
                    input+=sCurrentLine+"\n";
                
                }
             
                
        input+="\n";
              
        return input;
        } catch (IOException e) {
               
        } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
        return null;
        
    }

}
