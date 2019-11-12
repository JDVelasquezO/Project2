package node;

import javax.swing.JOptionPane;
import offer.Offers;
import product.Product;

/**
 * CircularList
 */
public class CircularList {

    private Node start;
    private int length; // Guardará el tamaño de la lista

    public CircularList() {
        start = null;
        length = 0;
    }

    public void add(Object value){
        Node node = new Node(value);
        if (isEmpty()) {
            start = node;
            node.next = start;
        } else {
            Node pointer = start;

            while (pointer.next != start) {
                pointer = pointer.next;
            }

            pointer.next = node;
            node.next = start;
        }
        
        length++;
    }

    // Saber si la lista está vacía o no
    public boolean isEmpty () {
        return start == null;
    }

    public Object getValue(int n) {
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
                return pointer.circularValue;
            }
        }
    }
    
    public Object getValue(String name) {
        if (isEmpty()) {
            return null;
        } else {
            Node pointer = start;
            while (!name.equals(pointer.circularValue) && pointer.next != null) {
                pointer = pointer.next;
            }

            if (!name.equals(pointer.circularValue)) {
                return null;
            } else {
                return pointer.circularValue;
            }
        }
    }
    
    public Object searchName(String names) {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            String[] data;
            data = names.split(";");
            Node aux = start;
            do {
                Product product = (Product) aux.circularValue;
                for (int i = 0; i < data.length; i++) {
                    if (data[i].equals(product.getName())) {
                        return product;
                    }
                }

                aux = aux.next;
            } while (aux != start);
        }
        
        return null;
    }

    // Eliminar uno en concreto:
    public void deleteForCounter (int n) {
        if (!isEmpty()) {
            if (n == 0) {
                Node first = start;
                start = start.next;
                first.next = null;
            } else if (n < length) {
                Node pointer = start;
                int counter = 0;
                while (counter < (n-1)) {
                    pointer = pointer.next;
                    counter++;
                }
                
                Node temp = pointer.next; // Obtenemos la posición en concreto
                pointer.next = temp.next; // La igualamos a su siguiente
                temp.next = null; // Eliminamos el nodo en concreto
            }

            length--;
        }
    }
    
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
                System.out.println(counter + " es distinto de " + n);
            } else {
                pointer.circularValue = newValue;
            }
        }
    }

    // Obtener la longitud de la lista
    public int getLength () {
        return length;
    }
}
