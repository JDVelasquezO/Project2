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
public class Node {
    
    public Object circularValue;
    public Offer value;
    public Node next;

    public Node(Object value, Node next) {
        this.circularValue = value;
        this.next = next;
    }

    public Node(Object value) {
        this(value, null);
    }

    // Incersión al inicio
    public Node(Offer value) {
        this.value = value;
    }
    
    public Node(Offer value, Node next) {
        this.value = value;
        this.next = next;
    }
}
