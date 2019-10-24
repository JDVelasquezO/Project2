/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author JDVelasquezO
 */
public class Product {
    
    public static int counter = 0;
    private int n;
    private String id, name, desc, price, image;
    private boolean exist;
    
    public Product(String id, String name, String desc, String price, boolean exist, String image) {
        this.n = counter;
        counter++;
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.exist = exist;
        this.image = image;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean getExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return this.id + ". " + this.name + " " + this.desc + " Q. " + this.price + ", ";
    }
}
