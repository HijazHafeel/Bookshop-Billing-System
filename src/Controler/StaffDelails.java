/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.MyConn;

/**
 *
 * @author Hi! Hijaz
 */
public class StaffDelails {
     public static void save(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4,JTextField jtf5, JTextArea jta1, JRadioButton jrb1, JRadioButton jrb2, JTable jt1, JComboBox jcb1,JLabel jl1,JTextArea jta2) {
        String Ge = "";
        if (jrb1.isSelected()) {
            Ge = "Male";
        } else if (jrb2.isSelected()) {
            Ge = "Female";
        }
        int i = JOptionPane.showConfirmDialog(null, "insert");
        if (i == 0) {


            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    //String sql = "insert into staffdetails values ('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jta1.getText() + "','" + Ge + "','" + jtf5.getText() + "','"+jl1.getText()+"','" + jta2.getText() + "')";
                   String sql=" INSERT INTO `bookshops`.`staff` ( Staff_Id,First_Name, Last_Name, S_Address, S_telephone,Gender, active) VALUES ('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jta1.getText() + "','" + jtf5.getText() + "','" + Ge + "','" + jta2.getText() + "')";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Insert");
                    jtf2.setText("");
                    jtf3.setText("");
                    jta1.setText("");
                    jtf5.setText("");
                    jta2.setText("");
                    jrb1.setSelected(false);
                    jrb2.setSelected(false);
                }
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
            }

        }

    }
    public static void update(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4,JTextField jtf5, JTextArea jta1, JRadioButton jrb1, JRadioButton jrb2, JTable jt1, JComboBox jcb1,JTextArea jta2){
     String Ge = "";
        if (jrb1.isSelected()) {
            Ge = "Male";
        } else if (jrb2.isSelected()) {
            Ge = "Female";
        }
        int i = JOptionPane.showConfirmDialog(null, "Update");
        if (i == 0) {

            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    String sql = "Update `bookshops`.`staff` set First_Name = '" + jtf2.getText() + "',Last_Name = '" + jtf3.getText() + "',S_Address = '" + jta1.getText() + "',S_telephone = '" + jtf5.getText() + "',Gender='" + Ge + "' ,active='"+jta2.getText()+"'where Staff_Id='" + jtf1.getText() + "'";
                    MyConn.save(sql);

                    JOptionPane.showMessageDialog(null, "Updateed");
                }
            } catch (Exception e) {

             JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    public static void delete(JTextField jtf1){
         int i = JOptionPane.showConfirmDialog(null, "Delete");
        if (i == 0) {



            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    String sql = "Delete from `bookshops`.`staff` where Staff_Id = '" + jtf1.getText() + "'";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Delete");
                }
            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);

            }
        }
    
    }
    public static void search(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4,JTextField jtf5, JTextArea jta1,JTextArea jta2, JRadioButton jrb1, JRadioButton jrb2, JTable jt1, JComboBox jcb1){
    try {
        String e=jcb1.getSelectedItem().toString();
        
        if (e.equals("Id")) {
            e="Staff_Id";
        } else if(e.equals("Name")){
            e="First_Name";
        }
        
            String sql = "select * from `bookshops`.`staff` where " +e + " like '%" + jtf4.getText() + "%'";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int a = df.getRowCount();
            for (int i = 0; i < a; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("Staff_Id"));
                v.add(rs.getString("First_Name"));
                v.add(rs.getString("Last_Name"));
                v.add(rs.getString("S_Address"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("S_telephone"));
                df.addRow(v);

                jtf1.setText(rs.getString("Staff_Id"));
                jtf2.setText(rs.getString("First_Name"));
                jtf3.setText(rs.getString("Last_Name"));
                jta1.setText(rs.getString("S_Address"));
                jtf5.setText(rs.getString("S_telephone"));
                jta2.setText(rs.getString("active"));
                String g = rs.getString("Gender");
                if (g.equals("Male")) {
                    jrb1.setSelected(true);
                    jrb2.setSelected(false);
                } else if(g.equals("Female")) {
                    jrb2.setSelected(true);
                    jrb1.setSelected(false);
                }
                
//                if (g.equals("Male")) {
//                    jrb1.setSelected(true);
//                    jrb2.setSelected(false);
//
//                } else {
//                    jrb2.setSelected(true);
//                    jrb1.setSelected(false);
//
//                }
            }
            if (jtf4.getText().equals("")) {
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf5.setText("");
                jta1.setText("");
                jta2.setText("");
                df.removeRow(0);
                jrb1.setSelected(false);
                jrb2.setSelected(false);
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void ser(JTable jt1){
     try {
            String sql = "select * from `bookshops`.`staff`";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int a = df.getRowCount();
            for (int i = 0; i < a; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("Staff_Id"));
                v.add(rs.getString("First_Name"));
                v.add(rs.getString("Last_Name"));
                v.add(rs.getString("S_Address"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("S_telephone"));
                df.addRow(v);
            }

        } catch (Exception e) {
        }
    }
    public static void tab(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4,JTextField jtf5, JTextArea jta1,JTextArea jta2, JRadioButton jrb1, JRadioButton jrb2, JTable jt1, JComboBox jcb1){
    int i = jt1.getSelectedRow();
        String s = (String) jt1.getValueAt(i, 0);
        jtf1.setText(s);
        String s1 = (String) jt1.getValueAt(i, 1);
        jtf2.setText(s1);
        String s2 = (String) jt1.getValueAt(i, 2);
        jtf3.setText(s2);
        String s6 = (String) jt1.getValueAt(i, 5);
        jtf5.setText(s6);
        String s4 = (String) jt1.getValueAt(i, 3);
        jta1.setText(s4);
        String s5 = (String) jt1.getValueAt(i, 4);
        if (s5.equals("Male")) {
            jrb1.setSelected(true);
            jrb2.setSelected(false);
        } else if (s5.equals("Female")) {
            jrb2.setSelected(true);
            jrb1.setSelected(false);
        }
        try {
            String sql = "SELECT * FROM `bookshops`.`staff` Where Staff_Id ='" + jtf1.getText() + "'";
            ResultSet rs = MyConn.search(sql);
            while (rs.next()) {
                String si = rs.getString("active");
                jta2.setText(si);
               
            }
        } catch (Exception e) {
        }
    
    }
            
}
