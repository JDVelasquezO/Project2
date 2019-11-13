/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import node.CircularList;

/**
 *
 * @author JDVelasquezO
 */
public class User {
    private int id;
    public static int counter = 0;
    private String name, last, email, pass, creditCard;
    private boolean type;
    private int lengthProducts;

    public User(String name, String last, String email, String pass, String creditCard, boolean type) {
        this.id = counter;
        counter++;
        this.name = name;
        this.last = last;
        this.email = email;
        this.pass = pass;
        this.creditCard = creditCard;
        this.type = type;
        this.lengthProducts = 0;
    }
    
    public User(int id, String name, String last, String email, String pass, String creditCard, boolean type) {
        this.id = id;
        this.name = name;
        this.last = last;
        this.email = email;
        this.pass = pass;
        this.creditCard = creditCard;
    }
    
    public User() {
        this("---", "---", "example@gmail.com", "123", "456", false);
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getLengthProducts() {
        return lengthProducts;
    }

    public void setLengthProducts(int lengthProducts) {
        this.lengthProducts = lengthProducts;
    }
    
    @Override
    public String toString() {
        return email + pass;
    }
}
