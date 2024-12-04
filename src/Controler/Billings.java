/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.MyConn;

/**
 *
 * @author Hi! Hijaz
 */
public class Billings {

    public static void ser(JTable jt1) {

        try {
            String sql = "select * from bookshops.books ";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int o = df.getRowCount();
            for (int i = 0; i < o; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("ISBN"));
                v.add(rs.getString("Book_name"));
                v.add(rs.getString("Book_price"));
                v.add(rs.getString("Book_type"));
                v.add(rs.getString("Stock"));
                df.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4, JTextField jtf5) {
        try {
            String sql = "SELECT * FROM bookshops.books Where ISBN ='" + jtf1.getText() + "'";
            ResultSet rs = MyConn.search(sql);
            while (rs.next()) {

                jtf2.setText(rs.getString("Book_name"));
                jtf3.setText(rs.getString("Book_price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enter(JTable jt2 ,JLabel jl1,JLabel jl2) {
        for (int i = 0; i < jt2.getRowCount(); i++) {
          
        try {
            
            String s =   (String) jt2.getValueAt(i, 0);
             String s1 =  (String) jt2.getValueAt(i, 1);
            String s2 = (String) jt2.getValueAt(i, 2);
            String s3 = (String) jt2.getValueAt(i, 3);
            String s4 = (String) jt2.getValueAt(i, 4);
            String s5="";
            System.out.println(s);
             System.out.println(s1);
              System.out.println(s2);
               System.out.println(s3);
                System.out.println(s4);


            String sql = "INSERT INTO `bookshops`.`biiling` (`I_Id`, `Books_ISBN`, `staff_Staff_Id`, `Time`, `B_Qty`) VALUES ('"+jl2.getText()+"', '"+s1+"', '2', '"+jl1.getText()+"', '"+s3+"')";
           MyConn.save(sql);
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        JOptionPane.showMessageDialog(null, "saved");
//        int in=Integer.parseInt(jl1.getText());
//        jl2.setText(in+1+"");
    }
    public static void in(JLabel jl1){
        try {
             String sql = "select * from bookshops.biiling ";
            ResultSet rs = MyConn.search(sql);
             while (rs.next()) {
             int id=Integer.parseInt(rs.getString("I_Id"));
                 
                 jl1.setText(id+1+"");
             
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
           
    
    
    }
}
