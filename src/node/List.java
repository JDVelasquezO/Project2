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
    
    // Al final
    public void addFinish (Object value) {
        Node node = new Node(value);
        if (isEmpty()) {
            start = node;
        } else {
            Node pointer = start;
            while (pointer.next != null) {
                pointer = pointer.next;
            }

            pointer.next = node;
        }
        length++;
    }
    
    // Obtener un nodo
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
    
    // Modificar un nodo en concreto:
    public void modifyNode (int n, Object newValue) {
        if (isEmpty()) {
            System.out.println("La cabeca esta vacía");
        } else {
            Node pointer = start;
            int counter = 0;
            
            while (counter < n && pointer.next != null) {
                pointer = pointer.next;
                counter++;
            }
            
            if (counter != n) {
                System.out.println("Contador es distinto de " + n);
            } else {
                pointer.value = newValue;
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
