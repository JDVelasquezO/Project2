/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.awt.Rectangle;
import javax.swing.JLabel;
import login.Login;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import node.DoubleCircularList;
import offer.Offer;
import product.Product;
import static proyecto2.Proyecto2.circularList;
import static proyecto2.Proyecto2.doubleCircularList;
import static proyecto2.Proyecto2.objectTemp;
import static proyecto2.Proyecto2.priorityQueue;
import static proyecto2.Proyecto2.stack;
import static user.ClientProducts.counterKart;
import static user.ClientProducts.infoKart;
import static user.ClientProducts.lengthProductsTotal;
import static user.ClientProducts.priceProduct;

/**
 *
 * @author JDVelasquezO
 */
public class ClientHome extends javax.swing.JFrame {
    String nameText, typeClient;
    int length = circularList.getLength();
    JLabel[] labels;
    JLabel[] labels2;
    JButton[] button;
    Border border = BorderFactory.createLineBorder(Color.black, 1);
    DecimalFormat df;
    public static int lengthProductsTotal = 0;
    public static String infoKart;
    public static int counterKart = 0;
    public static double priceProduct = 0;
    
    public ClientHome() {
        initComponents();
        
        setLocationRelativeTo(null);
        setTitle("Cliente");
        
        verifyProducts();
        typeClient = "";
        
        if (objectTemp.isType()) {
            typeClient = "Consumidor Frecuente";
        }
        
        df = new DecimalFormat("#.00");
        infoKart = "";
        jButtonKart.setText("(0) Q 0.00");
        
        labels = new JLabel[length];
        labels2 = new JLabel[length];
        button = new JButton[length];
        nameText = objectTemp.getName();
        jLabel1.setText("Bienvenido " + nameText);
        jButton3.requestFocus();
        
        if (!doubleCircularList.isEmpty()) {
            infoKart = "(" + counterKart + ") " + " Q." + df.format(priceProduct);
            jButtonKart.setText(infoKart);
        }
        
        for (int i = 0; i < priorityQueue.getLength(); i++) {
            Offer offer = (Offer) priorityQueue.getValue(i);
            String name = "", dir = "", price = "";
            ImageIcon img = null;
            for (int j = 0; j < offer.getProducts().getLength(); j++) {
                Product prod = (Product) offer.getProducts().getValue(j);
                name = prod.getName();
                dir = prod.getImage();
                price = prod.getPrice();
                img = new ImageIcon(dir);
                System.out.println(name);

                labels[j] = new JLabel();
                labels[j].setBounds(new Rectangle((j)*220, 35, 200, 150));
                int width = labels[j].getWidth();
                int height = labels[j].getHeight();
                Icon icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                labels[j].setIcon(icon);
                labels[j].setHorizontalAlignment(SwingConstants.CENTER);
                labels[j].setCursor(new Cursor(HAND_CURSOR));

                labels2[j] = new JLabel();
                labels2[j].setBounds(new Rectangle((j)*220, 130, 200, 150));
                labels2[j].setHorizontalAlignment(SwingConstants.CENTER);
                labels2[j].setText(name + " Q." + price);
                labels2[j].setCursor(new Cursor(HAND_CURSOR));

                button[j] = new JButton();
                button[j].setBounds(new Rectangle((j)*240, 220, 100, 20));
                button[j].setHorizontalAlignment(SwingConstants.CENTER);
                button[j].setCursor(new Cursor(HAND_CURSOR));
                button[j].setText("Añadir al carrito");

                jTextArea1.add(labels[j], null);
                jTextArea1.add(labels2[j], null);
                jTextArea1.add(button[j], null);
            }
        }
        
        //setButtonEvent(button);
    }
    
    public void setButtonEvent(JButton[] button) {
        for (int i = 0; i < button.length; i++) {
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id = 0; double price;
                    counterKart++;
                    JButton obj = (JButton)e.getSource();
                    String[] data = obj.getText().split(" ");
                    id = Integer.parseInt(data[0]);
                    price = Double.parseDouble(data[2]);
                    double priceProductActual = price;
                    priceProduct += priceProductActual;
                    
                    if (objectTemp.isType()) {
                        priceProduct = priceProduct - (priceProduct * 0.2);
                    }
                    
                    infoKart = "(" + counterKart + ") " + " Q." + df.format(priceProduct);
                    jButtonKart.setText(infoKart);
                    Product product = (Product) circularList.getValue(id);
                    doubleCircularList.add(product);
                }
            });
        }
    }
    
    public void verifyProducts() {
        //System.out.println(lengthProductsTotal);
        if (lengthProductsTotal >= 3) {
            objectTemp.setType(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButtonKart = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Bievenido");

        jButton1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton1.setText("Modificar Perfil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton2.setText("Cerrar Sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setText("Ofertas");

        jButton3.setText("Todos los productos en tienda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonKart.setText("(0) Q.0.00");

        jButton5.setText("Pagar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonKart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonKart)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ModifyClient modifyClient = new ModifyClient();
        modifyClient.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
        objectTemp = null;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ClientProducts cp = new ClientProducts();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonKart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
