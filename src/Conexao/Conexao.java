
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
   public Connection getConnection(){
     try{
         return DriverManager.getConnection("jdbc:mysql://localhost/oficina","root","");
         
     }
     catch(SQLException erro){
       
       throw new RuntimeException(erro);
   }
   }
}
