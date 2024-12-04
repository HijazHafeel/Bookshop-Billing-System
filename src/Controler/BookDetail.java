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
public class BookDetail {

    public static void search(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4, JTextField jtf5, JTextArea jta1, JTable jt1, JComboBox jcb1, JComboBox jcb2, JComboBox jcb3, JComboBox jcb4) {
        String p = "";
        String p1 = "";
        String a = "";
        String a1 = "";
        try {


            String sql = "select * from bookshops.books where " + jcb1.getSelectedItem().toString() + " like '%" + jtf4.getText() + "%'";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int o = df.getRowCount();
            for (int i = 0; i < o; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                a = rs.getString("Author_Au_Id");
                p = rs.getString("Publishers_Pu_Id");
                try {
                    String sq = "select * from author where Au_Id like'" + a + "' ";
                    ResultSet r = MyConn.search(sq);

                    while (r.next()) {
                        a1 = r.getString("Au_Name");
                        jcb2.setSelectedItem(a1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    String sq = "select * from publishers where Pu_Id like'" + p + "' ";
                    ResultSet r = MyConn.search(sq);

                    while (r.next()) {
                        p1 = r.getString("Pu_Name");
                        jcb3.setSelectedItem(p1);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Vector v = new Vector();
                v.add(rs.getString("ISBN"));
                v.add(rs.getString("Book_name"));
                v.add(rs.getString("Book_price"));
                v.add(rs.getString("Book_type"));
                v.add(p1);
                v.add(a1);
                v.add(rs.getString("Stock"));
                df.addRow(v);

                jtf1.setText(rs.getString("ISBN"));
                jtf2.setText(rs.getString("Book_name"));
                jtf3.setText("Rs " + rs.getString("Book_price") + "/-");
                jcb4.setSelectedItem(rs.getString("Book_type"));
                jtf5.setText(rs.getString("Stock"));
                jta1.setText(rs.getString("Contain"));


            }
            if (jtf4.getText().equals("")) {
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf5.setText("");
                jta1.setText("");

                df.removeRow(0);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static void save(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4, JTextField jtf5, JTextArea jta1, JTable jt1, JComboBox jcb1, JComboBox jcb2, JComboBox jcb3, JComboBox jcb4) {

        int i = JOptionPane.showConfirmDialog(null, "insert");
        if (i == 0) {
            try {
                int e = jcb4.getSelectedIndex() + 1;
                int p = jcb2.getSelectedIndex() + 1;
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    //     INSERT INTO `bookshops`.`books` (`B_code`, `Book_name`, `Book_type`, `Book_price`, `Pub_date`, `Stock`, `Contain`, `Publishers_Pu_Id`, `Author_Au_Id`) VALUES ('2', 'hfjj', 'jojv', '54', '8888888', '54', 'l;', 'kp', 'icj');
                    //String sql = "insert into staffdetails values ('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jta1.getText() + "','" + Ge + "','" + jtf5.getText() + "','"+jl1.getText()+"','" + jta2.getText() + "')";
                    String sql = " INSERT INTO `bookshops`.`books` (`ISBN`, `Book_name`, `Book_type`, `Book_price`, `Pub_date`, `Stock`, `Contain`, `Publishers_Pu_Id`, `Author_Au_Id`) VALUES ('" + jtf1.getText() + "', '" + jtf2.getText() + "', '" + jcb3.getSelectedItem().toString() + "', '" + jtf3.getText() + "','1', '" + jtf5.getText() + "', '" + jta1.getText() + "', '" + e + "', '" + p + "')";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Insert");
                    jtf2.setText("");
                    jtf3.setText("");
                    jta1.setText("");
                    jtf5.setText("");


                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

        }

    }

    public static void update(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4, JTextField jtf5, JTextArea jta1, JTable jt1, JComboBox jcb1, JComboBox jcb2, JComboBox jcb3, JComboBox jcb4) {

        int i = JOptionPane.showConfirmDialog(null, "Update");
        if (i == 0) {

            try {
                int a = jcb4.getSelectedIndex() + 1;
                int p = jcb2.getSelectedIndex() + 1;
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    String sql = "UPDATE `bookshops`.`books` SET `Book_name`='" + jtf2.getText() + "', `Book_type`='" + jcb3.getSelectedItem().toString() + "', `Book_price`='" + jtf3.getText() + "', `Stock`='" + jtf5.getText() + "', `Contain`='" + jta1.getText() + "', `Publishers_Pu_Id`='" + p + "', `Author_Au_Id`='" + a + "' WHERE `ISBN`='" + jtf1.getText() + "' ";
                    MyConn.save(sql);

                    JOptionPane.showMessageDialog(null, "Updateed");
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void delete(JTextField jtf1) {
        int i = JOptionPane.showConfirmDialog(null, "Delete");
        if (i == 0) {



            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    String sql = "Delete from `bookshops`.`books` where ISBN = '" + jtf1.getText() + "'";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Delete");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

    }

    public static void ser(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4, JTextField jtf5, JTextArea jta1, JTable jt1, JComboBox jcb1, JComboBox jcb2, JComboBox jcb3, JComboBox jcb4) {
        try {
            String p = "";
            String p1 = "";
            String a = "";
            String a1 = "";
            String sql = "select * from bookshops.books ";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int o = df.getRowCount();
            for (int i = 0; i < o; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                a = rs.getString("Author_Au_Id");
                p = rs.getString("Publishers_Pu_Id");
                try {
                    String sq = "select * from author where Au_Id like'" + a + "' ";
                    ResultSet r = MyConn.search(sq);

                    while (r.next()) {
                        a1 = r.getString("Au_Name");
                        jcb2.setSelectedItem(a1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    String sq = "select * from publishers where Pu_Id like'" + p + "' ";
                    ResultSet r = MyConn.search(sq);

                    while (r.next()) {
                        p1 = r.getString("Pu_Name");
                        jcb4.setSelectedItem(p1);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Vector v = new Vector();
                v.add(rs.getString("ISBN"));
                v.add(rs.getString("Book_name"));
                v.add(rs.getString("Book_price"));
                v.add(rs.getString("Book_type"));
                v.add(p1);
                v.add(a1);
                v.add(rs.getString("Stock"));
                df.addRow(v);
            }
        } catch (Exception e) {
        }
    }

    public static void au(JComboBox jcb1) {
        try {
            String sql = "select * from author";
            ResultSet rs = MyConn.search(sql);

            while (rs.next()) {
                String s=rs.getString("Au_Name");
                jcb1.addItem(s);           
            }
      

        } catch (Exception e) {
            e.printStackTrace();
        }
    }public static void pu(JComboBox jcb1) {
        try {
            String sql = "select * from publishers";
            ResultSet rs = MyConn.search(sql);

            while (rs.next()) {
                String s=rs.getString("Pu_Name");
                jcb1.addItem(s);           
            }
      

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void tab(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4,JTextField jtf5, JTable jt1, JComboBox jcb2,JComboBox jcb3,JComboBox jcb4){
     int i = jt1.getSelectedRow();
        String s = (String) jt1.getValueAt(i, 0);
        jtf1.setText(s);
        String s1 = (String) jt1.getValueAt(i, 1);
        jtf2.setText(s1);
        String s2 = (String) jt1.getValueAt(i, 2);
        jtf3.setText(s2);
        String s4 = (String) jt1.getValueAt(i, 6);
        jtf5.setText(s4);
        String s5 = (String) jt1.getValueAt(i, 3);
        jcb3.setSelectedItem(s5);
        String s6 = (String) jt1.getValueAt(i, 4);
        jcb4.setSelectedItem(s6);
        String s7 = (String) jt1.getValueAt(i, 5);
        jcb2.setSelectedItem(s7);
     }
}
