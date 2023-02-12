/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import mycode.dbconnect;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Acer
 */
public class invoice extends javax.swing.JPanel {

    /**
     * Creates new form invoice
     */
    public invoice() {
        initComponents();
        
         jPanel1.setBackground(new Color(255,255,255,220));
       
        jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,24));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(157,136,203));
        jTable1.getTableHeader().setForeground( Color.BLACK);
        jTable1.setRowHeight(35);
        dataload();
    }
    
    
    public void dataload(){
        
   
        try {
            
        DefaultTableModel dt =(DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
            
           Statement  s = dbconnect.connect().createStatement();
           ResultSet rs=s.executeQuery("SELECT * FROM sales "); 
           
           while(rs.next()){
              Vector v = new Vector();
              
              v.add(rs.getString(1));
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(6));
             
              dt.addRow(v);
               
               
           }
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        
   
        
    }
    public void search_para(){
        
        String inv_id = id.getText();
        String sta = com_status.getSelectedItem().toString();
        try{
            
           DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
           dt.setRowCount(0);
           Statement  s = dbconnect.connect().createStatement();
           ResultSet rs=s.executeQuery("SELECT * FROM sales WHERE inid LIKE '%"+inv_id+"%' AND status LIKE '%"+sta+"%'");
            
           while(rs.next()){
               
             Vector v = new Vector();  
              v.add(rs.getString(1));
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(6));
              dt.addRow(v);
           }
            
        }catch(SQLException e){
            
           System.out.println(e);
            dataload();;
        }
        
        
        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        com_status = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1917, 848));
        setPreferredSize(new java.awt.Dimension(1917, 848));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("status :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 90, 40));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel3.setText("invoice no :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 130, 40));

        id.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 280, 40));

        com_status.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        com_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "unpaid", "partial", " " }));
        com_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_statusActionPerformed(evt);
            }
        });
        com_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                com_statusKeyReleased(evt);
            }
        });
        jPanel1.add(com_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 170, 40));

        jButton1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 150));

        jTable1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sale ID", "Invoice NO", "Total QTY", "Bill Total", "Status", "Balance"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1910, 700));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/1844418.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1917, 848));
    }// </editor-fold>//GEN-END:initComponents

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased
        search_para();
    }//GEN-LAST:event_idKeyReleased

    private void com_statusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_com_statusKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_com_statusKeyReleased

    private void com_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_statusActionPerformed
        search_para();
    }//GEN-LAST:event_com_statusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      dataload();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox com_status;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
