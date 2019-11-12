/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

public class Stack {

    private Node top;
    private int length;

    public Stack () {
        setTop(null);
    }

    public void push (Object value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
        length++;
    }

    public void pop () {
        if (!isEmpty()) {
            Node first = top;
            top = top.next;
            first.next = null;
            length--;
        }
    }

    public Object getValue(int n) {
        if (isEmpty()) {
            return null;
        } else {
            Node pointer = top;
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

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the top
     */
    public Node getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Node top) {
        this.top = top;
    }

    public boolean isEmpty () {
        return top == null;
    }
}