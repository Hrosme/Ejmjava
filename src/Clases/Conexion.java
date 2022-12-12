/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rosme
 */

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {
    Connection cn;
    
     public Connection getConnect (){
        try{
          //  Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/prueba","root","Depositoa7998");
            System.out.print("Conexion");
        }catch(Exception e){
           // System.out.println(e.getMessage());
            System.out.println("Error");
        }
        return cn;
    }
Statement createStatement(){
    throw new UnsupportedOperationException("No soportado");
}
}
