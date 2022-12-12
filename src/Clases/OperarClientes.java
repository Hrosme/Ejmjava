/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rosme
 */
public class OperarClientes {
     Conexion con =new Conexion();
    Connection cn=con.getConnect();
    DefaultTableModel modelo= new DefaultTableModel();
    
    public void AgregarCliente(String ClienteID,String ClienteNombre, String ClienteApellido, String CLienteTelefono, String ClienteCorreo ){
           try{
            Statement s=cn.createStatement();
            String query = "INSERT INTO prueba.cliente(ClienteID, ClienteNombre, ClienteApellido, CLienteTelefono, ClienteCorreo) values ('"+ClienteID+"','"+ClienteNombre+"','"+ClienteApellido+"','"+CLienteTelefono+"','"+ClienteCorreo+"')";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO CORRECTAMENTE");
            }catch(Exception e){JOptionPane.showMessageDialog(null,e);}    
     }
    
     public DefaultTableModel lista(){
    Statement s;    
        try {
            s = cn.createStatement();
    
    //consuta a mostrar*/
    String query = "select * from cliente";
    ResultSet rs = s.executeQuery(query);
   ResultSetMetaData rsmd=rs.getMetaData();
   //obtenemos numero de columnas 
   int CanColumns = rsmd.getColumnCount();
    //comprobamos 
   for(int i=1;i<=CanColumns;i++){
       //cargamos columnas en modelo
   modelo.addColumn(rsmd.getColumnLabel(i));
   }
   while (rs.next()){
   //creamos array 
       Object[] fila=new Object[CanColumns];
   //cargamos datos a modelo
   for(int i=0;i<CanColumns;i++){
   fila[i] = rs.getObject(i+1);
   }
   modelo.addRow(fila);
   }
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    //retornamos modelo para jtable
    return modelo;
      
}
     
      public void EliminarCliente(String Id){
       try{
       Statement s=cn.createStatement();
       String query="DELETE FROM cliente WHERE ClienteID='"+Id+"'";
       s.executeUpdate(query);
       s.close();
       cn.close();
       JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
       }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
        }
    
     public void ModificarCliente(String ClienteID,String ClienteNombre, String ClienteApellido, String ClienteTelefono, String ClienteCorreo){
        try{
        Statement s=cn.createStatement();
        String query = "UPDATE cliente SET ClienteNombre='"+ClienteNombre+"', ClienteApellido='"+ClienteApellido+"', ClienteTelefono='"+ClienteTelefono+"', ClienteCorreo='"+ClienteCorreo+"' WHERE ClienteID='"+ClienteID+"'";
        s.executeUpdate(query);
        s.close();
        cn.close();
        JOptionPane.showMessageDialog(null, "MODIFICADO CORRECTAMENTE");
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
     }
     
  
}
