/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.MyConn;

/**
 *
 * @author Hi! Hijaz
 */
public class AuthorDitail {

    public static void save(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextArea jta1, JRadioButton jrb1, JRadioButton jrb2, JTable jt1, String s) {
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
                    //String sql = " INSERT INTO `bookshops`.`staff` ( Staff_Id,First_Name, Last_Name, S_Address, S_telephone,Gender, active) VALUES ('" + jtf1.getText() + "','" + jtf2.getText() + "','" + jtf3.getText() + "','" + jta1.getText() + "','" + jtf5.getText() + "','" + Ge + "')";
                    String sql = "INSERT INTO `bookshops`.`author` (`Au_Id`, `Au_Name`, `Address`, `Telephone`, `Gender`, `Au_pic`) VALUES ('" + jtf1.getText() + "', '" + jtf2.getText() + "', '" + jtf3.getText() + "', '" + jta1.getText() + "', '" + Ge + "', '" + s + "')";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Insert");
                    jtf2.setText("");
                    jtf3.setText("");
                    jta1.setText("");

                    jtf1.setText("");
                    jrb1.setSelected(false);
                    jrb2.setSelected(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    public void UpDate(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextArea jta1, JRadioButton jrb1, JRadioButton jrb2, String pe) {
        int i = JOptionPane.showConfirmDialog(null, "Update");
        String Ge = "";
        if (jrb1.isSelected()) {
            Ge = "Male";
        } else if (jrb2.isSelected()) {
            Ge = "Female";
        }
        if (i == 0) {
            try {
                if (jtf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "plese enter Id");
                } else if (pe == null) {
                    String u = "UPDATE `bookshops`.`author` SET `Au_Name`='" + jtf2.getText() + "', `Address`='" + jta1.getText() + "', `Telephone`='" + jtf3.getText() + "', `Gender`='" + Ge + "' WHERE `Au_Id`='" + jtf1.getText() + "'";
                    MyConn.save(u);

                    JOptionPane.showMessageDialog(null, "Updated");
                } else {
                    String u = "UPDATE `bookshops`.`author` SET `Au_Name`='" + jtf2.getText() + "', `Address`='" + jta1.getText() + "', `Telephone`='" + jtf3.getText() + "', `Gender`='" + Ge + "', `Au_pic`='" + pe + "' WHERE `Au_Id`='" + jtf1.getText() + "'";
                    MyConn.save(u);

                    JOptionPane.showMessageDialog(null, "Updated");
                }



            } catch (Exception e) {
                e.printStackTrace();
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
                    String sql = "Delete from `bookshops`.`author` where Au_Id = '" + jtf1.getText() + "'";
                    MyConn.save(sql);
                    JOptionPane.showMessageDialog(null, "Delete");
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static void ser(JTable jt1) {
        try {
            String sql = "select * from author";
            ResultSet rs = MyConn.search(sql);
            DefaultTableModel df = (DefaultTableModel) jt1.getModel();
            int a = df.getRowCount();
            for (int i = 0; i < a; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("Au_Id"));
                v.add(rs.getString("Au_Name"));

                v.add(rs.getString("Address"));
                v.add(rs.getString("Gender"));
                v.add(rs.getString("Telephone"));

                df.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void taba(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextArea jta1, JRadioButton jrb1, JRadioButton jrb2, JTable jt1, JLabel jl1) {
        int i = jt1.getSelectedRow();
        String s = (String) jt1.getValueAt(i, 0);
        jtf1.setText(s);
        String s1 = (String) jt1.getValueAt(i, 1);
        jtf2.setText(s1);
        String s2 = (String) jt1.getValueAt(i, 2);
        jta1.setText(s2);

        String s4 = (String) jt1.getValueAt(i, 4);
        jtf3.setText(s4);
        String s5 = (String) jt1.getValueAt(i, 3);
        if (s5.equals("Male")) {
            jrb1.setSelected(true);
            jrb2.setSelected(false);
        } else if (s5.equals("Female")) {
            jrb2.setSelected(true);
            jrb1.setSelected(false);
        }
        try {
            String sql = "SELECT * FROM author Where Au_Id ='" + jtf1.getText() + "'";
            ResultSet rs = MyConn.search(sql);
            while (rs.next()) {
                String si = rs.getString("Au_pic");
                //  si = si.replace("\\", "\\\\");
                ImageIcon image = new ImageIcon(new ImageIcon(si).getImage().getScaledInstance(jl1.getWidth(), jl1.getHeight(), Image.SCALE_SMOOTH));
                jl1.setIcon(image);
                // jPanel3.setBackground(new Color(0, 0, 0));
            }
        } catch (Exception e) {
        }
    }
    public static void fch(JLabel jl1,String s,String s1,String s2){
    try {
            JFileChooser ch = new JFileChooser();
            ch.showOpenDialog(null);
            File f = ch.getSelectedFile();
            s = f.getPath();
            s1 = f.getAbsolutePath();

            ImageIcon image = new ImageIcon(new ImageIcon(s1).getImage().getScaledInstance(jl1.getWidth(), jl1.getHeight(), Image.SCALE_SMOOTH));
            jl1.setIcon(image);
        
            s2 = s1.replace("\\", "\\\\");
            System.out.println(s2);

        } catch (Exception e) {
            e.printStackTrace();

        }
    
    }
}