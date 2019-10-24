
package files;

import java.io.*;

/**
 *
 * @author JDVelasquezO
 */
public class Files {
    public String read(String dir) {
        String text = "";
        
        try {
            FileReader file = new FileReader(dir);
            BufferedReader bf = new BufferedReader(file);
            String temp = "";
            String buferedRead;
            
            while ( (buferedRead = bf.readLine()) != null ) {
                temp = temp + buferedRead;
            }
            
            text = temp;
        } catch(Exception e) {
            System.out.println("No se encontro el archivo, error: " + e);
        }
        
        return text;
    }
}
