/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import mycode.dbconnect;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Acer
 */
public class profit extends javax.swing.JPanel {

    /**
     * Creates new form profit
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    
    
    public profit() {
        initComponents();
        jPanel1.setBackground(new Color(255,255,255,220));
          con =dbconnect.connect();
        tableload();
        jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,24));
        jTable1.getTableHeader().setOpaque(false);
       
        jTable1.getTableHeader().setBackground(new Color(255,51,51));
        jTable1.getTableHeader().setForeground( Color.BLACK);
        jTable1.setRowHeight(25);
            
       
    }
     public void tableload()
    {
       try{
      
         String sql = "SELECT  inid as 'Invoice NO', total_bill as 'Bill Total' ,status as 'Payment Status', date_s as 'Date' ,t_profit as 'Bill Profit' FROM sales" ;
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
               
       }catch(Exception e){
        
    }
    }

      public void date(){
    
         
         SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
     String fdate = df1.format(jDateChooser1.getDate());
     
     SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
     String tdate = df2.format(jDateChooser2.getDate());
     
             
     try{
            
           DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
           dt.setRowCount(0);
           Statement  s = dbconnect.connect().createStatement();
           ResultSet rs=s.executeQuery("SELECT * FROM sales WHERE date_s BETWEEN  '"+fdate+"' AND '"+tdate+"' ");
            
           while(rs.next()){
               
             Vector v = new Vector();  
              v.add(rs.getString(2));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(7));
              v.add(rs.getString(11));
              
              
              dt.addRow(v);
           }
            
        }catch(SQLException e){
            
           System.out.println(e);
            
        }
         
         
         
         
     }
      public void cart_total(){
        
        int numofrow = jTable1.getRowCount();
        
        
        double total = 0;
        
        for(int i =0 ; i<numofrow;i++){
            
           
           double value = Double.valueOf(jTable1.getValueAt(i,4).toString());
           total+=value;
           
        }
        String tot=String.format("%.2f", total); 
      // jLabel6.setText(Double.toString(tot));
       jLabel5.setText(tot);
      }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1917, 828));
        setMinimumSize(new java.awt.Dimension(1917, 828));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel5.setText("00.00");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 690, 150, 40));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\bill\\src\\main\\Search.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, 50));

        jDateChooser1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 340, 44));

        jDateChooser2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 340, 44));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 0, 1170, 830));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel2.setText("From   :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel3.setText("To        :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel4.setText("Total profit  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 830));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Untitled4.png")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 828));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        date();
     cart_total();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
