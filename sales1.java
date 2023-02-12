/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mycode.dbconnect;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author Acer
 */
public final class sales1 extends javax.swing.JPanel {

    Connection con=null;
    PreparedStatement pst=null;
    public static String barcode_c ="0";
    Double bill_profit= 0.0;
    /**
     * Creates new form sales
     */
    public sales1() {
        initComponents();
         jPanel1.setBackground(new Color(255,255,255,150));
        
          // jPanel2.setBackground(new Color(255,255,255,240));
            data_load();
            showDate();
            showTime();
        theder();
          con =dbconnect.connect();
        AutoCompleteDecorator.decorate(jComboBox1);
        
        
       //jTable1 .getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,24));
        jTable1.getTableHeader().setOpaque(true);
        jTable1.getTableHeader().setBackground(new Color(255,51,51));
        jTable1.getTableHeader().setForeground( Color.BLACK);
        jTable1.setRowHeight(35);
    }
  
    void showDate(){
    
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    Date d = new Date();
    date.setText(s.format(d));
    }
    private void theder(){
        
         JTableHeader theder = jTable1.getTableHeader();
          theder.setFont(new Font("Segoe UI",Font.BOLD,24));
        
    }
    
    void showTime(){
    
    new Timer(0 , new ActionListener() {
       
        @Override
        public void actionPerformed(ActionEvent e){
             SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
             Date d = new Date();
             time.setText(s.format(d));
            
        }
        
    }).start();
    }
    
      public void data_load(){
        
       try{
           
          Statement s = dbconnect.connect().createStatement(); 
          ResultSet rs = s.executeQuery("SELECT * FROM coustomer");
          Vector v = new Vector();
          while(rs.next()){
              
            v.add(rs.getString("cus_name"));
            
            DefaultComboBoxModel com = new DefaultComboBoxModel(v);
            jComboBox3.setModel(com);
              
              
          }
          
           
           
           
       } catch(Exception e){
           
       }   
          
       try{
           
          Statement s = dbconnect.connect().createStatement(); 
          ResultSet rs = s.executeQuery("SELECT * FROM addsave1");
          Vector v = new Vector();
          while(rs.next()){
              
            v.add(rs.getString("product_name"));
            
            DefaultComboBoxModel com = new DefaultComboBoxModel(v);
            jComboBox1.setModel(com);
              
              
          }
          
           
           
           
       } catch(Exception e){
           
       }
       
       try{
           
        Statement s= dbconnect.connect().createStatement(); 
        ResultSet rs=s.executeQuery("SELECT * FROM extra WHERE exid =1");
        if(rs.next()){
            invoice.setText(rs.getString("val"));
          
        }
           
           
       }catch(Exception e){
           
       }
       int i =Integer.valueOf(invoice.getText());
       i++;
       invoice.setText(String.valueOf(i));
  
      } 
     public void pro_tot_cal(){  
       
       
         
           Double uprice = Double.valueOf(price.getText());
           double qty;
           double tot;
           
         
      if(jComboBox2.getSelectedItem().equals("50g")){
         
             qty=0.05;
             tot =uprice*qty;
            
             String tot1=String.format("%.2f", tot);
              bill_total1.setText(String.valueOf(tot1));
         
     } if(jComboBox2.getSelectedItem().equals("100g")){
         
            qty=0.1;
            tot =uprice*qty;
            String tot1=String.format("%.2f", tot);
             bill_total1.setText(String.valueOf(tot1));
           
     } if(jComboBox2.getSelectedItem().equals("250g")){
         
          qty=0.25;
          tot =uprice*qty;
          String tot1=String.format("%.2f", tot);
           bill_total1.setText(String.valueOf(tot1));
          
     } if(jComboBox2.getSelectedItem().equals("500g")){
         
        qty=0.5;
        tot =uprice*qty;
        String tot1=String.format("%.2f", tot);
         bill_total1.setText(String.valueOf(tot1));
         
     } if(jComboBox2.getSelectedItem().equals("750g")){
         
        qty=0.75;
        tot =uprice*qty;
        String tot1=String.format("%.2f", tot);
         bill_total1.setText(String.valueOf(tot1));
         
     } if(jComboBox2.getSelectedItem().equals("1kg")){
        
         qty=1;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
          
     }if(jComboBox2.getSelectedItem().equals("2kg")){
        
         qty=2;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("3kg")){
        
         qty=3;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("4kg")){
        
         qty=4;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("5kg")){
        
         qty=5;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("6kg")){
        
         qty=6;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("7kg")){
        
         qty=7;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("8kg")){
        
         qty=8;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("9kg")){
        
         qty=9;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("10kg")){
        
         qty=10;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("11kg")){
        
         qty=11;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("12kg")){
        
         qty=12;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("13kg")){
        
         qty=13;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("14kg")){
        
         qty=14;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("15kg")){
        
         qty=15;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("16kg")){
        
         qty=16;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("17kg")){
        
         qty=17;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("18kg")){
        
         qty=18;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("19kg")){
        
         qty=19;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("20kg")){
        
         qty=20;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("21kg")){
        
         qty=21;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("22kg")){
        
         qty=22;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("23kg")){
        
         qty=23;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("24kg")){
        
         qty=24;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("25kg")){
        
         qty=25;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("26kg")){
        
         qty=26;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("27kg")){
        
         qty=27;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("28kg")){
        
         qty=28;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("29kg")){
        
         qty=29;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("30kg")){
        
         qty=30;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("31kg")){
        
         qty=31;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("32kg")){
        
         qty=32;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("33kg")){
        
         qty=33;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("34kg")){
        
         qty=34;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("35kg")){
        
         qty=35;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("36kg")){
        
         qty=36;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("37kg")){
        
         qty=37;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("38kg")){
        
         qty=38;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("39kg")){
        
         qty=39;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("40kg")){
        
         qty=40;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("41kg")){
        
         qty=41;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("42kg")){
        
         qty=42;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("43kg")){
        
         qty=43;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("44kg")){
        
         qty=44;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("45kg")){
        
         qty=45;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("46kg")){
        
         qty=46;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("47kg")){
        
         qty=47;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("48kg")){
        
         qty=48;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("49kg")){
        
         qty=49;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("50kg")){
        
         qty=50;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
          
     }if(jComboBox2.getSelectedItem().equals("1pac")){
        
         qty=1;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("1pac")){
        
         qty=1;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("2pac")){
        
         qty=2;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("3pac")){
        
         qty=3;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("4pac")){
        
         qty=4;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("5pac")){
        
         qty=5;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("6pac")){
        
         qty=6;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("7pac")){
        
         qty=7;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("8pac")){
        
         qty=8;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("9pac")){
        
         qty=9;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("10pac")){
        
         qty=10;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("11pac")){
        
         qty=11;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("12pac")){
        
         qty=12;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("13pac")){
        
         qty=13;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("14pac")){
        
         qty=14;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("15pac")){
        
         qty=15;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("16pac")){
        
         qty=16;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("17pac")){
        
         qty=17;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("18pac")){
        
         qty=18;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("19pac")){
        
         qty=19;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("20pac")){
        
         qty=20;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("21pac")){
        
         qty=21;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("22pac")){
        
         qty=22;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("23pac")){
        
         qty=23;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("24pac")){
        
         qty=24;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("25pac")){
        
         qty=25;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("26pac")){
        
         qty=26;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("27pac")){
        
         qty=27;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("28pac")){
        
         qty=28;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("29pac")){
        
         qty=29;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("30pac")){
        
         qty=30;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("31pac")){
        
         qty=31;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("32pac")){
        
         qty=32;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("33pac")){
        
         qty=33;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("34pac")){
        
         qty=34;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("35pac")){
        
         qty=35;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("36pac")){
        
         qty=36;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("37pac")){
        
         qty=37;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("38pac")){
        
         qty=38;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("39pac")){
        
         qty=39;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("40pac")){
        
         qty=40;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("41pac")){
        
         qty=41;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("42pac")){
        
         qty=42;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("43pac")){
        
         qty=43;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("44pac")){
        
         qty=44;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("45pac")){
        
         qty=45;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("46pac")){
        
         qty=46;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("47pac")){
        
         qty=47;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("48pac")){
        
         qty=48;
        
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("49pac")){
        
         qty=49;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }if(jComboBox2.getSelectedItem().equals("50pac")){
        
         qty=50;
         tot =uprice*qty;
         String tot1=String.format("%.2f", tot);
          bill_total1.setText(String.valueOf(tot1));
     }
      
           
     }   
        
    public void cart_total(){
        
        int numofrow = jTable1.getRowCount();
        
        
        double total = 0;
        
        for(int i =0 ; i<numofrow;i++){
            
           
           double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
           total+=value;
           
        }
        
       jLabel13.setText(Double.toString(total));
         int numofrows = jTable1.getRowCount();
        
        
        double totals = 0;
        
        for(int i =0 ; i<numofrows;i++){
            
           
           double values= Double.valueOf(jTable1.getValueAt(i, 4).toString());
           totals+=values;
           
        }
        
       tot_qty.setText(Double.toString(totals));
    }
    
    public void tot(){
        
       Double paid = Double.valueOf(paid_amt.getText());
        Double tot = Double.valueOf(jLabel13.getText());
        Double due;
        
        due=paid-tot;
        blnc.setText(String.valueOf(due)); 
        
        
        
        
    }
    public void cal_qty(){
       
        try { 
            
           
    
      String sql="update addsave1 set quantity=quantity-? where unit=? ";
        
           pst=con.prepareStatement(sql);
          
       for(int i=0;i<jTable1.getRowCount();i++){
        
           String pid = (String)jTable1.getValueAt(i, 2);
         String qty=(String)jTable1.getValueAt(i, 4);
        
         String st=qty.replaceAll("[^\\d]", "");
         // pst.setString(1, digits);  
          double str;
          String quantity;
         if(st.equals("50")){
             
            str=0.050;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
          
      } else if(st.equals("100")){
             
             str=0.100;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
      } else if(st.equals("250")){
             
             str=0.250;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
                 
               
         } else if(st.equals("500")){
             
             str=0.500;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
             
         } else if(st.equals("750")){
             
             str=0.750;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
             
         } else if(st.equals("1")){
             
             str=1.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
             
         } else if(st.equals("2")){
             
             str=2.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }  else if(st.equals("3")){
             
             str=3.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         } else if(st.equals("4")){
             
             str=4.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         } else if(st.equals("5")){
             
             str=5.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         } else if(st.equals("6")){
             
             str=6.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         } else if(st.equals("7")){
             
             str=7.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
             
         } else if(st.equals("8")){
             
             str=8.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
             
         } else if(st.equals("9")){
             
             str=9.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
             
         } else if(st.equals("10")){
             
             str=10.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
           
             
         } else if(st.equals("10")){
             
             str=10.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }   else if(st.equals("11")){
             
             str=11.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }   else if(st.equals("12")){
             
             str=12.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }   else if(st.equals("13")){
             
             str=13.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("14")){
             
             str=14.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("15")){
             
             str=15.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("16")){
             
             str=16.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("17")){
             
             str=17.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("18")){
             
             str=18.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("19")){
             
             str=19.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("20")){
             
             str=20.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("21")){
             
             str=21.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("22")){
             
             str=22.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("23")){
             
             str=23.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("24")){
             
             str=24.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("25")){
             
             str=25.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("26")){
             
             str=26.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
         }   else if(st.equals("27")){
             
             str=27.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }     else if(st.equals("28")){
             
             str=28.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }     else if(st.equals("29")){
             
             str=29.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }    else if(st.equals("30")){
             
             str=30.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("31")){
             
             str=31.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("32")){
             
             str=32.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("33")){
             
             str=33.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("34")){
             
             str=34.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("35")){
             
             str=35.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("36")){
             
             str=36.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("37")){
             
             str=37.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("38")){
             
             str=38.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("39")){
             
             str=39.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }      else if(st.equals("40")){
             
             str=40.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }       else if(st.equals("41")){
             
             str=41.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }        else if(st.equals("42")){
             
             str=42.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("43")){
             
             str=43.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }        else if(st.equals("44")){
             
             str=44.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("45")){
             
             str=45.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("46")){
             
             str=46.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("47")){
             
             str=47.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("48")){
             
             str=48.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("49")){
             
             str=49.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }         else if(st.equals("50")){
             
             str=50.0;
            quantity=Double.toString(str);
             pst.setString(1, quantity);
             
         }       
        
               pst.setString(2, pid);
               pst.execute();
       }
        } catch (Exception e) {
           
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        price = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        br_code = new javax.swing.JLabel();
        blnc = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        invoice = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        paid_amt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bill_total1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1917, 848));
        setPreferredSize(new java.awt.Dimension(1917, 848));
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice id", "Product Name", "Bar Code", "Unit Price", "Quantity", "Total"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 1220, 610));

        jButton1.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/shop-cart-add-icon.png"))); // NOI18N
        jButton1.setText("Add to cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 220, -1));

        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Shopping-basket-remove-icon.png"))); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 700, 171, -1));

        jButton3.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/cart-remove-icon.png"))); // NOI18N
        jButton3.setText("Remove all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 700, -1, -1));

        jButton4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Print.png"))); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1740, 690, 139, -1));

        price.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        price.setText("00.00");
        add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 102, 60));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        jLabel13.setText("00.00");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 640, 140, 25));

        br_code.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        br_code.setText("0");
        add(br_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 239, 34));

        blnc.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        blnc.setText("00.00");
        add(blnc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 770, 140, 23));

        date.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 650, 170, 40));

        time.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 740, 170, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/animated-dollar-sign-gif.gif"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 700, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/date.gif"))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 640, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/time.gif"))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 740, -1, -1));

        jPanel1.setMinimumSize(new java.awt.Dimension(1917, 848));
        jPanel1.setPreferredSize(new java.awt.Dimension(1917, 848));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 370, 41));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel5.setText("quantity          :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 56));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel8.setText("unit price         :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 171, 57));

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel7.setText("total                 :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 171, 58));

        jComboBox2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "50g", "100g", "250g", "500g", "750g", "1kg", "2kg", "3kg", "4kg", "5kg", "6kg", "7kg", "8kg", "9kg", "10kg", "11kg", "12kg", "13kg", "14kg", "15kg", "16kg", "17kg", "18kg", "19kg", "20kg", "21kg", "22kg", "23kg", "24kg", "25kg", "26kg", "27kg", "28kg", "29kg", "30kg", "31kg", "32kg", "33kg", "34kg", "35kg", "36kg", "37kg", "38kg", "39kg", "40kg", "41kg", "42kg", "43kg", "44kg", "45kg", "46kg", "47kg", "48kg", "49kg", "50kg", "1pac", "2pac", "3pac", "4pac", "5pac", "6pac", "7pac", "8pac", "9pac", "10pac", "11pac", "12pac", "13pac", "14pac", "15pac", "16pac", "17pac", "18pac", "19pac", "20pac", "21pac", "22pac", "23pac", "24pac", "25pac", "26pac", "27pac", "28pac", "29pac", "30pac", "31pac", "32pac", "33pac", "34pac", "35pac", "36pac", "37pac", "38pac", "39pac", "40pac", "41pac", "42pac", "43pac", "44pac", "45pac", "46pac", "47pac", "48pac", "49pac", "50pac" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 130, 37));

        invoice.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        invoice.setText("00");
        jPanel1.add(invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 55, 40));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel11.setText("total              :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 640, 156, 25));

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel10.setText("paid amount :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 700, 156, 36));

        paid_amt.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        paid_amt.setText("0.0");
        paid_amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paid_amtActionPerformed(evt);
            }
        });
        paid_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amtKeyReleased(evt);
            }
        });
        jPanel1.add(paid_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 700, 117, -1));

        jLabel12.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel12.setText("balance          :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 770, -1, -1));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("invoice no        :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel4.setText("product name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 53));

        bill_total1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jPanel1.add(bill_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 239, 60));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel6.setText("coustomer       :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, 50));

        jComboBox3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", " " }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 370, 41));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1917, 848));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/1844418.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1917, 848));

        tot_qty.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        tot_qty.setText("00");
        add(tot_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 76, 23));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
         String name =jComboBox1.getSelectedItem().toString();
        try{
            
           Statement s =dbconnect.connect().createStatement();
           ResultSet rs = s.executeQuery("SELECT unit,unit_price FROM addsave1 WHERE product_name ='"+name+"'");
           if(rs.next()){
               
              price.setText(rs.getString("unit_price"));
              br_code.setText(rs.getString("unit"));
              
               
           }
           
           pro_tot_cal();
           
            
        }catch(Exception e){
            
            
            
            
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         DefaultTableModel dt =(DefaultTableModel) jTable1.getModel();
        Vector v = new Vector();
        v.add(invoice.getText());
        v.add(jComboBox1.getSelectedItem().toString());
        v.add(br_code.getText());
        v.add(price.getText());
        v.add(jComboBox2.getSelectedItem().toString());
        v.add(bill_total1.getText());
        
        dt.addRow(v);
        cart_total();
         tot();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          try{
            
           DefaultTableModel dt =(DefaultTableModel) jTable1.getModel();
           int rw = jTable1.getSelectedRow();
           
           dt.removeRow(rw);
            
            
        }catch(Exception e){
            
            
        }
        cart_total();
         tot();
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel dt =(DefaultTableModel) jTable1.getModel();
         dt.setRowCount(0);
        cart_total();
         tot();
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void paid_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyReleased
        // TODO add your handling code here:
         tot();
    }//GEN-LAST:event_paid_amtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
            
        
      try{
         
       DefaultTableModel dt =(DefaultTableModel)jTable1.getModel();
       int rc = dt.getRowCount();
       
       for(int i =0;i<rc; i++){
           
           String inid = dt.getValueAt(i, 0).toString();
           String p_name = dt.getValueAt(i, 1).toString();
           String bar_code = dt.getValueAt(i, 2).toString();
           String u_price = dt.getValueAt(i, 3).toString();
           String qty = dt.getValueAt(i, 4).toString();
           String tota = dt.getValueAt(i, 5).toString();
           Statement s =dbconnect.connect().createStatement();
           ResultSet rs = s.executeQuery("SELECT profit FROM addsave1 WHERE product_name ='"+p_name+"'");
             if(rs.next()){
               String pro=rs.getString("profit");
               String st=pro.replaceAll("[^\\d]", "");
               Double pro1=Double.valueOf(st);
               Double pro2=pro1/100.00;
              Double tota1=Double.valueOf(tota);
              
              Double profit = Math.round(pro2*tota1)/100.00;
               
              bill_profit = bill_profit+profit;
              
             
            String tot1=String.format("%.2f", profit);
            Statement ss =dbconnect.connect().createStatement();
            ss.executeUpdate("INSERT INTO cart (inid , product_name , bar_code , qty , uniit_price ,total_price,f_profit) VALUES('"+inid+"' , '"+p_name+"' , '"+bar_code+"' , '"+qty+"' , '"+u_price+"' , '"+tota+"' , '"+tot1+"')");
       
       }}
       
          JOptionPane.showMessageDialog(null, "Data Saved");
          
          
          
          
      }catch(HeadlessException | SQLException e){
           System.out.println(e);
      }
    
        try{
            String inv_id=invoice.getText();
            String totalq = tot_qty.getText();
           // String totalb = jLabel13.getText();
            Double totalb=Double.valueOf(jLabel13.getText());
            String totalb1=String.format("%.2f", totalb);
            
            
          // String bln = blnc.getText();
            Double bln=Double.valueOf(blnc.getText());
            String bln1=String.format("%.2f", bln);
            
           String da= date.getText();
           
           String ti=time.getText();

            
            Double tot=Double.valueOf(jLabel13.getText());
             
            Double pid=Double.valueOf(paid_amt.getText());
            String tatus = null;
            
            if(pid.equals(0.0)){
                tatus = "Unpaid";
            }else if(tot>pid){
                tatus = "Partial";
            }else if(tot<=pid) {
                tatus = "Paid";
               }
            String cus = jComboBox3.getSelectedItem().toString();
            Double paid = Double.valueOf(paid_amt.getText());
            Double tot1 = Double.valueOf(jLabel13.getText());
            Double arrears1=0.00;
        
        if(tot1>paid)
        {
            arrears1=tot1-paid;
            
            
        }else if(tot1<=paid)
        {
            
            arrears1=0.00;
            
        }
            String arrears11=String.format("%.2f", arrears1); 
           
                
                
                String allbillf=String.format("%.2f", bill_profit);
           
             Statement s = dbconnect.connect().createStatement();
            s.executeUpdate("INSERT INTO sales (inid , total_qty ,total_bill , status , balance , date_s , time_s ,name , arrears , t_profit) VALUES('"+inv_id+"' , '"+totalq+"' , '"+totalb1+"' , '"+tatus+"' , '"+bln1+"' , '"+da+"' , '"+ti+"' , '"+cus+"' , '"+arrears11+"', '"+allbillf+"' ) ");
          
        }catch(SQLException e){
          System.out.println(e);
        } 
          
      
            
      try{
       String id =invoice.getText();
        Statement s=dbconnect.connect().createStatement();
        s.executeUpdate("UPDATE extra SET val='"+id+"' WHERE exid=1 ");
           
      }catch(SQLException e){
          System.out.println(e);
      }     
        
    cal_qty();
        
      try{
        
       String reportSourse  ="src\\main\\bill.jrxml";
        
        
       HashMap<String, Object> params = new HashMap<String, Object>();
    
       params.put("INV_ID",invoice.getText()); 
        JasperReport jreport=JasperCompileManager.compileReport(reportSourse);
         con= dbconnect.connect();  
          JasperPrint jprint = JasperFillManager.fillReport(jreport,params, con);
        JasperViewer.viewReport(jprint);
      JasperPrintManager.printReport(jprint, true);
        con.close();
         
      
       
       }catch(Exception e){
           
      
     
      }
       
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void paid_amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paid_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paid_amtActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
        pro_tot_cal();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bill_total1;
    private javax.swing.JLabel blnc;
    private javax.swing.JLabel br_code;
    private javax.swing.JLabel date;
    private javax.swing.JLabel invoice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField paid_amt;
    private javax.swing.JLabel price;
    private javax.swing.JLabel time;
    private javax.swing.JLabel tot_qty;
    // End of variables declaration//GEN-END:variables

}
