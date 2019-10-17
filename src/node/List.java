/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author JDVelasquezO
 */
public class List {
    
    private Node start; // Puntero
    private int length; // Guardará el tamaño de la lista
    
    public List() {
        start = null;
        length = 0;
    }
    
    // Metodos de incersión:
    // Al inicio
    public void addStart (Object value) {
        Node node = new Node(value);
        node.next = start;
        start = node;
        this.length++;
    }
    
    public Object getValue (int n) {
        if (isEmpty()) {
            return null;
        } else {
            Node pointer = start;
            int counter = 0;
            while (counter < n && pointer.next != null) {
                pointer = pointer.next;
                counter++;
            }

            if (counter != n) {
                return null;
            } else {
                return pointer.value;
            }
        }
    }
    
    // Saber si la lista está vacía o no
    public boolean isEmpty () {
        return start == null;
    }
    
    // Obtener la longitud de la lista
    public int getLength () {
        return length;
    }
}
