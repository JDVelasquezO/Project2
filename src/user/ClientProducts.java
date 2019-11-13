/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import bill.GenerateBill;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import kart.Kart;
import kart.ShoopingKart;
import login.Login;
import node.DoubleCircularList;
import product.Product;
import static proyecto2.Proyecto2.circularList;
import static proyecto2.Proyecto2.circularList3;
import static proyecto2.Proyecto2.doubleCircularList;
import static proyecto2.Proyecto2.objectProduct;
import static proyecto2.Proyecto2.objectTemp;
import static proyecto2.Proyecto2.stack;

/**
 *
 * @author JDVelasquezO
 */
public class ClientProducts extends javax.swing.JFrame {
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
    /**
     * Creates new form ClientProducts
     */
    public ClientProducts() {
        initComponents();
        setLocationRelativeTo(null);
        
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
        jLabel2.setText("Bienvenido " + nameText + " - " + typeClient);
        
        if (!doubleCircularList.isEmpty()) {
            infoKart = "(" + counterKart + ") " + " Q." + df.format(priceProduct);
            jButtonKart.setText(infoKart);
        }
        
        chargueProducts();
        setButtonEvent(button);
    }
    
    public void verifyProducts() {
        //System.out.println(lengthProductsTotal);
        if (lengthProductsTotal >= 3) {
            objectTemp.setType(true);
        }
    }
    
    public void chargueProducts() {
        for (int i = 0; i < circularList.getLength(); i++) {
            String name = "", dir = "", price = "";
            ImageIcon img = null;
            
            Product prod = (Product) circularList.getValue(i);
            name = prod.getName();
            dir = prod.getImage();
            price = prod.getPrice();
            img = new ImageIcon(dir);
            //System.out.println(name);

            labels[i] = new JLabel();
            labels[i].setBounds(new Rectangle((i)*220, 35, 200, 150));
            int width = labels[i].getWidth();
            int height = labels[i].getHeight();
            Icon icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            labels[i].setIcon(icon);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setCursor(new Cursor(HAND_CURSOR));

            labels2[i] = new JLabel();
            labels2[i].setBounds(new Rectangle((i)*220, 130, 200, 150));
            labels2[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels2[i].setText(name);
            labels2[i].setCursor(new Cursor(HAND_CURSOR));

            button[i] = new JButton();
            button[i].setBounds(new Rectangle((i)*240, 220, 220, 20));
            button[i].setHorizontalAlignment(SwingConstants.CENTER);
            button[i].setCursor(new Cursor(HAND_CURSOR));
            button[i].setText(prod.getId() + " - " + price);

            jTextArea1.add(labels[i], null);
            jTextArea1.add(labels2[i], null);
            jTextArea1.add(button[i], null);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonKart = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Todos los productos:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel2.setText("Bievenido");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonKart.setText("(0) Q.0.00");

        jButton5.setText("Pagar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonKart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonKart)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        objectTemp = null;
        typeClient = "";
        lengthProductsTotal = 0;
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ClientHome ch = new ClientHome();
        ch.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ShoopingKart sk = new ShoopingKart();
        sk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientProducts().setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
