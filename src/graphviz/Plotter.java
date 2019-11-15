/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import node.Node;
import product.Product;

/**
 *
 * @author JDVelasquezO
 */
public class Plotter {
    
    private static String graph;
    
    public static void graficar(Node start){
        
        if (start == null) {
            return;
        } 
        
        try {

            String dirPng = "C:\\Users\\JDVelasquezO\\Desktop\\Lista.png";
            String dirDot = "C:\\Users\\JDVelasquezO\\Desktop\\Lista.txt";

            PrintWriter writer = new PrintWriter(dirDot, "UTF-8");
            graph = "digraph G{";
            graph += "\nrankdir=\"LR\";\nnode [shape=circle];\nnode [style=filled];\nnode [fillcolor=\"#EEEEEE\"];\nnode [color=\"#EEEEEE\"];\nedge [color=\"#31CEF0\"];\n";

            Node aux = start;
            int idNode = 1;
            int counter = -1;
            Product prodName = (Product) aux.circularValue;

            while (aux.next != start) {
                graph += "\n\"" +  idNode + "\"[label=\"Valor: " + prodName.getName() + "\"];\n";
                
                if(idNode != 1){
                    graph += "\"" + (idNode - 1) + "\"" + " -> " + "\"" + idNode + "\"" + "[label=\"Siguiente\"];\n";
                    graph += "\"" + (idNode) + "\"" + " -> " + "\"" + (idNode - 1) + "\"" + "[label=\"Anterior\"];\n";
                }
                
                idNode++;
                counter++;
                aux = aux.next;
                
                if (aux.next == start) {
                    graph += "\n\"" +  idNode + "\"[label=\"Valor: " + prodName.getName() + "\"];\n";
                    graph += "\"" + (idNode - 1) + "\"" + " -> " + "\"" + idNode + "\"" + "[label=\"       \"];\n";
                    graph += "\"" + (idNode) + "\"" + " -> " + "\"" + (idNode - 1) + "\"" + "[label=\"      \"];\n";
                    counter++;

                    graph += "\"" + (idNode) + "\"" + " -> " + "\"" + (idNode - counter) + "\"" + "[label=\"                  \"];\n";
                    graph += "\"" + (idNode - counter) + "\"" + " -> " + "\"" + (idNode) + "\"" + "[label=\"                   \"];\n";
                }
            }

            graph += "}";

            writer.print(graph);
            writer.close();

            String cmd = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot " + " -Tpng " + " -o " + " " + dirPng + " " + dirDot;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            
            openFile(dirPng);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void openFile (String path) {
        try {
            File objetofile = new File (path);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
