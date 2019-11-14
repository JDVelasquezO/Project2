/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import node.DoubleCircularList;

/**
 *
 * @author JDVelasquezO
 */
public class Bill {
    
    private DoubleCircularList productsList;
    public static int counter = 1;
    private int number;
    private String type, nameClient, nitClient, typeClient, date, dir, targetClient;
    private double discount, subtotal, total;

    public Bill(String type, String nameClient, String nitClient, String typeClient, 
            String date, String dir, String targetClient, double discount, double subtotal, double total,
            DoubleCircularList products) {
        this.number = counter;
        counter++;
        this.type = type;
        this.nameClient = nameClient;
        this.nitClient = nitClient;
        this.typeClient = typeClient;
        this.date = date;
        this.dir = dir;
        this.targetClient = targetClient;
        this.discount = discount;
        this.subtotal = subtotal;
        this.total = total;
        this.productsList = products;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNitClient() {
        return nitClient;
    }

    public void setNitClient(String nitClient) {
        this.nitClient = nitClient;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTargetClient() {
        return targetClient;
    }

    public void setTargetClient(String targetClient) {
        this.targetClient = targetClient;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DoubleCircularList getProductsList() {
        return productsList;
    }

    public void setProductsList(DoubleCircularList productsList) {
        this.productsList = productsList;
    }
}
