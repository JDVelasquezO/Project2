/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import offer.Offer;

/**
 *
 * @author JDVelasquezO
 */
public class PriorityQueue {
    
    private Node start;
    public int length = 0;
    
    public void queuing(Offer offer) {
        if (isEmpty()) {
            start = new Node(offer);
            length++;
            return;
        }
        
        if (offer.getPriority().equalsIgnoreCase("alta")) {
            start = new Node(offer, start);
            length++;
            return;
        } else {
            Node aux = start;
            
            while (aux.next != null) {
                aux = aux.next;
            }
            
            aux.next = new Node(offer);
            length++;
            return;
        }
    }

    public void order() {
        Node first = start;
        Node aux = null;

        Offer offer;

        while (first.next != null && first.value.getPriority().equalsIgnoreCase("alta")) {
            aux = first.next;

            while (aux != null && aux.value.getPriority().equalsIgnoreCase("alta")) {
                if (first.value.getId() > aux.value.getId()) {
                    offer = aux.value;
                    aux.value = first.value;
                    first.value = offer;
                }
                aux = aux.next;
            }
            first = first.next;
        }
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
    
    public void deleteStart () {
        if (!isEmpty()) {
            Node first = start;
            start = start.next;
            first.next = null;
            length--;
        }
    }
    
    public boolean isEmpty () {
        return start == null;
    }

    public int getLength () {
        return length;
    }
}
