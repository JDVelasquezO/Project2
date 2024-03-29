/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import kart.Kart;
import login.Login;
import node.CircularList;
import node.DoubleCircularList;
import node.SimpleList;
import node.PriorityQueue;
import node.Stack;
import product.Product;
import user.User;

/**
 *
 * @author JDVelasquezO
 */
public class Proyecto2 {

    public static SimpleList list;
    public static CircularList circularList;
    public static CircularList circularList2;
    public static CircularList circularList3;
    public static PriorityQueue priorityQueue;
    public static DoubleCircularList doubleCircularList;
    public static Stack stack;
    public static User objectTemp;
    public static Product objectProduct;
    
    public static void main(String[] args) {
        list = new SimpleList();
        circularList = new CircularList();
        circularList2 = new CircularList();
        priorityQueue = new PriorityQueue();
        doubleCircularList = new DoubleCircularList();
        stack = new Stack();
        
        User user = new User("Daniel", "Velasquez", "jd@gmail.com", "123", "1234", false);
        User user2 = new User("Josefino", "Orozco", "josefino@gmail.com", "123", "4321", false);
        list.addStart(user);
        list.addFinish(user2);
        
        /*Product product1 = new Product("0", "Vue", 
                "Curso inicial de Vuejs", "45", true, "C:\\Users\\JDVelasquezO\\Documents\\images\\vue.png");
        Product product2 = new Product("1", "React", 
                "Curso inicial de React", "100", true, "C:\\Users\\JDVelasquezO\\Documents\\images\\react.png");
        circularList.add(product1);
        circularList.add(product2);*/
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
