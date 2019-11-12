package node;

import product.Product;

/**
 * DoubleCircularList
 */
public class DoubleCircularList {

    private Node start;
    private int length;

    public DoubleCircularList () {
        start = null; length = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getLength () {
        return length;
    }
    
    public Node getStart () {
        return start;
    }

    public void add (Object value) {
        Node node = new Node(value);
        if (isEmpty()) {
            start = node;
            node.next = start;
            node.previous = start;
        } else {
            Node pointer = start;

            while (pointer.next != start) {
                pointer = pointer.next;
            }

            pointer.next = node;
            node.previous = pointer;
            node.next = start;
            start.previous = node;
        }

        //System.out.println(node.circularValue);
        length++;
    }
    
    public void delete (int id) {
        Node pointer = start;
        int counter = 0;
        Product prod = (Product) start.circularValue;
        
        if (id == Integer.parseInt(prod.getId())) {
            start.previous.next = start.next;
            start.next.previous = start.previous;
            start = start.next;
        }

        while (counter < id && pointer.next != null) {
            pointer = pointer.next;
            counter++;
        }
        
        pointer.previous.next = pointer.next;
        pointer.next.previous = pointer.previous;
        // pointer = null;

        length--;
    }
    
    public void delete (Object value) {
        Node pointer = start;

        while (pointer.circularValue != value && pointer.next != null) {
            pointer = pointer.next;
        }
        
        pointer.previous.next = pointer.next;
        pointer.next.previous = pointer.previous;

        length--;
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
}
