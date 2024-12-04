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
public class Publisher {

    public static void save(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextArea jta1) {

        int i = JOptionPane.showConfirmDialog(null, "insert");
        if (i == 0) {


            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    //String sql = "insert into staffdetails values ('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jta1.getText() + "','" + Ge + "','" + jtf5.getText() + "','"+jl1.getText()+"','" + jta2.getText() + "')";
                    //String sql = " INSERT INTO `bookshops`.`staff` ( Staff_Id,First_Name, Last_Name, S_Address, S_telephone,Gender, active) VALUES ('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jta1.getText() + "','" + jtf5.getText() + "','" + Ge + "')";
                    String sql = "INSERT INTO `bookshops`.`publishers` (`Pu_Id`, `Pu_Name`, `Pu_Address`, `Pu_Contact`) VALUES ('" + jtf1.getText() + "', '" + jtf2.getText() + "', '" + jta1.getText() + "', '" + jtf3.getText() + "')";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Insert");
                    jtf2.setText("");
                    jtf3.setText("");
                    jta1.setText("");

                    jtf1.setText("");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    public void UpDate(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextArea jta1) {
        int i = JOptionPane.showConfirmDialog(null, "Update");

        if (i == 0) {
            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else {
                    String u = "UPDATE `bookshops`.`publishers` SET `Pu_Name`='" + jtf2.getText() + "', `Pu_Address`='" + jta1.getText() + "', `Pu_Contact`='" + jtf3.getText() + "' WHERE `Pu_Id`='" + jtf1.getText() + "'";
                    MyConn.save(u);

                    JOptionPane.showMessageDialog(null, "Updated");

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
                    String sql = "Delete from publishers where Pu_Id = '" + jtf1.getText() + "'";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Delete");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    public static void ser(JTable jt1) {
        try {
            String sql = "select * from publishers";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int a = df.getRowCount();
            for (int i = 0; i < a; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("Pu_Id"));
                v.add(rs.getString("Pu_Name"));
                v.add(rs.getString("Pu_Address"));
                v.add(rs.getString("Pu_Contact"));


                df.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void tab(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextArea jta1, JTable jt1) {
        int i = jt1.getSelectedRow();
        String s = (String) jt1.getValueAt(i, 0);
        jtf1.setText(s);
        String s1 = (String) jt1.getValueAt(i, 1);
        jtf2.setText(s1);
        String s2 = (String) jt1.getValueAt(i, 2);
        jta1.setText(s2);
        String s3 = (String) jt1.getValueAt(i, 3);
        jtf3.setText(s3);

    }
}
