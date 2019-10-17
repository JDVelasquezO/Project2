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
public class Node {
    
    public Object value;
    public Node next;

    // Incersión al inicio
    public Node(Object value) {
        this.value = value;
    }
}
