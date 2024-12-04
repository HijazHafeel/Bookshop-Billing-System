 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class MyConn {
    static Connection c;
    
    private static void NewConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/BookShops";
        c = DriverManager.getConnection(url, "root", "1234");
    }
    
    public static ResultSet search(String sql) throws Exception {
        if (c == null) {
            NewConnection();
        }
        ResultSet rs = c.createStatement().executeQuery(sql);
        return rs;
    }

    public static void save(String sql) throws Exception {
        if (c == null) {
            NewConnection();
        }
        c.createStatement().execute(sql);
        
    }
    
}
