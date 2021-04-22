
package Dao;

import Classes6.Cliente;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


        
        
public class DaoCliente {
    
    private Connection con;
    private ResultSet rs;
    
   public DaoCliente(){
    this.con = new Conexao().getConnection();
}
   
public void cadastrar(Cliente cli){
    try{
     PreparedStatement p=con.prepareStatement
     ("insert into cliente (nome,telefone,numero,complemento,cep) values(?,?,?,?,?)");        
        p.setString(1,cli.getNome());
        p.setString(2,cli.getTelefone());
        p.setInt(3,cli.getNumero());
        p.setString(4,cli.getComplemento());
        p.setString(5, cli.getCep());
        p.executeUpdate();
        p.close();
        
        
    }
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
}
public void alterar(Cliente cli){
    try{
     PreparedStatement p=con.prepareStatement
     ("update cliente set nome=?,telefone=?,numero=?,complemento=?,cep=? where "
     + "idcliente = '"+cli.getIdCliente()+"'");    
     
        p.setString(1,cli.getNome());
        p.setString(2,cli.getTelefone());
        p.setInt(3,cli.getNumero());
        p.setString(4,cli.getComplemento());
        p.setString(5, cli.getCep());
        p.executeUpdate();
        p.close();
        
        
    }
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
}
public void buscacod(Cliente cli){
   try{
       PreparedStatement p=con.prepareStatement
        ("select * from cliente where idcliente = '"+cli.getIdCliente()+"'");
        
        rs=p.executeQuery();
        
        if(rs.first()){
            cli.setIdCliente(rs.getInt("idcliente"));
            cli.setNome(rs.getString("nome"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setNumero(rs.getInt("numero"));
            cli.setComplemento(rs.getString("complemento"));
            cli.setCep(rs.getString("cep"));
        }
        else{
           JOptionPane.showMessageDialog(null,"cliente não encontrado!!"); 
        }
       p.close();
   } 
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
}

public void buscanome(Cliente cli){
   try{
       PreparedStatement p=con.prepareStatement
        ("select * from cliente where nome = '"+cli.getNome()+"'");
        
        rs=p.executeQuery();
        
        if(rs.first()){
            cli.setIdCliente(rs.getInt("idcliente"));
            cli.setNome(rs.getString("nome"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setNumero(rs.getInt("numero"));
            cli.setComplemento(rs.getString("complemento"));
            cli.setCep(rs.getString("cep"));
        }
        else{
           JOptionPane.showMessageDialog(null,"cliente não encontrado!!"); 
        }
       p.close();
   } 
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
}
public List<Cliente>PreencheClientes(){
   try{
       List<Cliente>clientes=new ArrayList<Cliente>();
       PreparedStatement p=con.prepareStatement("select * from cliente");
       rs=p.executeQuery();
       
       while(rs.next()){
          Cliente cli = new Cliente();
      cli.setIdCliente(rs.getInt("idcliente"));
            cli.setNome(rs.getString("nome"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setNumero(rs.getInt("numero"));
            cli.setComplemento(rs.getString("complemento"));
            cli.setCep(rs.getString("cep"));
            clientes.add(cli);
       }
       return clientes;
   } 
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
}
}
