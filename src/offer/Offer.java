package offer;

import node.CircularList;
import static proyecto2.Proyecto2.circularList;
import static proyecto2.Proyecto2.circularList2;

/**
 *
 * @author JDVelasquezO
 */
public class Offer {
    
    public static int counter = 0;
    private int id;
    private String desc, discount, priority;
    private CircularList products;
    
    public Offer (String desc, String discount, String priority) {
        setId(counter++); setDesc(desc); setDiscount(discount); setPriority(priority);
        products = new CircularList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public CircularList getProducts() {
        return products;
    }

    public void setProducts(CircularList products) {
        this.products = products;
    }

    @Override
    public String toString() {
        // return desc + " su descuento es " + discount;
        String string = desc + "\n" + ": ";
        for (int i = 0; i < products.getLength(); i++) {
            string += "\t" + products.getValue(i) + "\n";
        }

        return string;
    }
}
