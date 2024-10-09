/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

//import com.mysql.jdbc.Connection;
//import java.sql.DriverManager;
//import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class DBConnection {
    
    public static Connection connect()
    {
        Connection conn = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/newinventory","root","");
           //JOptionPane.showMessageDialog(null, "connection success");

        }catch (Exception e) {
            System.out.println("Connection Error : "+e);
           // JOptionPane.showMessageDialog(null, "connection success");
            
        }
      
       return conn;
    }
     
}
