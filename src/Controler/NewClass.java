/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Hi! Hijaz
 */
public class NewClass {

    static Timer t;
    static int d = 100;

    public static void time(final JLabel jl1) {
        t = new Timer(d, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                String D = "dd:MM:yyyy ";
                String T = "hh:mm:ss   aa     ";
                SimpleDateFormat a = new SimpleDateFormat(T + D);
                jl1.setText(a.format(d));
                Calendar c = new GregorianCalendar();
                int s = c.get(Calendar.MONTH);


            }
        });
        t.start();
    }
//    public static void t(final String ta){
//     t = new Timer(d, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Date d = new Date();
//              
//                String T = "hh:mm:ss:aa";
//                SimpleDateFormat a = new SimpleDateFormat(T);
//               
//                Calendar c = new GregorianCalendar();
//                int s = c.get(Calendar.MONTH);
//
//
//            }
//        });
//        t.start();
//    
//    
//    }

    public void internetgoogle() {
        try {
            Desktop.getDesktop().browse(URI.create("www.google.com"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void app(){
        try {
            Runtime rt=Runtime.getRuntime();
            Process p=rt.exec("Calc");
            p.waitFor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}}