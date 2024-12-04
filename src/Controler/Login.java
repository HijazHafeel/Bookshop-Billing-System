/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import bookshops.login;
import bookshops.Billing;
import bookshops.staffdetails;
import java.sql.ResultSet;
import javax.swing.*;
import model.MyConn;

/**
 *
 * @author Hi! Hijaz
 */
public class Login {

    static boolean pr = true;

    public static void reset(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4) {
        try {
            String sql = "select * from  `bookshops`.`staff` where  First_Name='" + jtf1.getText() + "'&&Last_Name='" + jtf2.getText() + "'";
            ResultSet rs = MyConn.search(sql);

            while (rs.next()) {
                if (jtf3.getText().equals(jtf4.getText())) {
                    String s = rs.getString("Staff_Id");


                    try {
                        String sq = "Update  `bookshops`.`staff` set password = '" + jtf4.getText() + "' where Staff_Id='" + s + "'";
                        MyConn.save(sq);

                        JOptionPane.showMessageDialog(null, "Password Reset");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "please enter correct ");

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4, JLabel jl1) {
        if (jtf3.getText().equals(jtf4.getText())) {

            try {

                String sql = "Update  `bookshops`.`staff` set password='" + jtf3.getText() + "',username='" + jtf2.getText() + "' where Staff_Id ='" + jtf1.getText() + "'";
                MyConn.save(sql);
                JOptionPane.showMessageDialog(null, "Insert");
                JOptionPane.showMessageDialog(null, "This is your new Password:-" + jtf3.getText());
            } catch (Exception e) {
                e.printStackTrace();

            }
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
            jtf4.setText("");
        } else {
            jl1.setText("Password is not mach please enter again");
        }
    }

    public void pas(JPasswordField jps1, JTextField jtf1, JTextField jtf2, JLabel jl1) {
        String s = jps1.getText();
        if (pr) {
           
            jtf1.setText(s);
            jps1.setVisible(false);
            jtf1.setVisible(true);
            jl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/hide_16px.png"))); // NOI18N
            // jLabe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/hide_16px.png")));
            pr = false;
        } else {
            jtf1.setVisible(false);
            jps1.setVisible(true);
            jl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pict/eye_16px.png")));
            pr = true;
        }
    }
    public static void log(JPasswordField jps1, JTextField jtf1){
        
        login log=new bookshops.login();
     
    
    }
}
