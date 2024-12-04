/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshops;

/**
 *
 * @author Hi! Hijaz
 */
public class Bookshops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lodingfram a = new Lodingfram();
        a.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(50);



                if (i == 1) {
                    Lodingfram.jLabel1.setText("We");
                }
                if (i == 5) {
                    Lodingfram.jLabel1.setText("Welc");
                }
                if (i == 10) {
                    Lodingfram.jLabel1.setText("Welcom");
                }
                if (i == 15) {
                    Lodingfram.jLabel1.setText("Welcome");
                }
                if (i == 20) {
                    Lodingfram.jLabel1.setText("Welcome  ");
                }
                if (i == 25) {
                    Lodingfram.jLabel1.setText("Welcome to");
                }
                if (i == 30) {
                    Lodingfram.jLabel1.setText("Welcome to ");
                }
                if (i == 35) {
                    Lodingfram.jLabel1.setText("Welcome to H");
                }
                if (i == 36) {
                    Lodingfram.jLabel1.setText("Welcome to HH");
                }
                if (i == 40) {
                    Lodingfram.jLabel1.setText("Welcome to HHA");
                }
                if (i == 45) {
                    Lodingfram.jLabel1.setText("Welcome to HHA B");
                }
                if (i == 50) {
                    Lodingfram.jLabel1.setText("Welcome to HHA Bo");
                }
                if (i == 55) {
                    Lodingfram.jLabel1.setText("Welcome to HHA Boo");
                }
                if (i == 60) {
                    Lodingfram.jLabel1.setText("Welcome to HHA Book");
                }
                if (i == 65) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookS");
                }
                if (i == 70) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookSh");
                }
                if (i == 75) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookSho");
                }
                if (i == 80) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookShop");
                }
                if (i == 85) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookShop.");
                }
                if (i == 90) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookShop..");
                }
                if (i == 95) {
                    Lodingfram.jLabel1.setText("Welcome to HHA BookShop...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        //new login1().setVisible(true);
        a.dispose();
    }
}
