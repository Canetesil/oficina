
package Dao;


import Classes6.Cliente;
import Classes6.peca;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DaoPeca {
    
    private Connection con;
    private ResultSet rs;
    
   public DaoPeca(){
    this.con = new Conexao().getConnection();
}
    
    public void cadastrar(peca pe){
    try{
     PreparedStatement p=con.prepareStatement
     ("insert into peca (nome,preco_unitario,qt_estoque) values(?,?,?)");        
        p.setString(1,pe.getNome());
        p.setDouble(2,pe.getPreco_Unitario());
        p.setInt(3,pe.getQt_Estoque());
        p.executeUpdate();
        p.close();    
    }
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
    }
    
    public void alterar(peca pe){
    try{
     PreparedStatement p=con.prepareStatement
     ("update peca set nome=?,preco_unitario=?,qt_estoque=? where "
     + "idpeca = '"+pe.getIdpeca()+ "'");    
     
        p.setString(1,pe.getNome());
        p.setDouble(2,pe.getPreco_Unitario());
        p.setInt(3,pe.getQt_Estoque());
        p.executeUpdate();
        p.close();
    
        
    }
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
      
    }
public void buscacod(peca pe){
   try{
       PreparedStatement p=con.prepareStatement
        ("select * from peca where idpeca = '"+pe.getIdpeca()+"'");
        
        rs=p.executeQuery();
        
        if(rs.first()){
            pe.setIdpeca(rs.getInt("idpeca"));
            pe.setNome(rs.getString("nome"));
            pe.setQt_Estoque(rs.getInt("qt_estoque"));
            pe.setPreco_Unitario(rs.getDouble("preco_unitario"));
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
public void buscapeca(peca pe){
   try{
       PreparedStatement p=con.prepareStatement
        ("select * from peca where nome = '"+pe.getNome()+"'");
        
        rs=p.executeQuery();
        
        if(rs.first()){
            pe.setIdpeca(rs.getInt("idpeca"));
            pe.setNome(rs.getString("nome"));
            pe.setQt_Estoque(rs.getInt("qt_estoque"));
            pe.setPreco_Unitario(rs.getDouble("preco_unitario"));
            
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
public List<peca>PreenchePeca(){
   try{
       List<peca>pecas=new ArrayList<peca>();
       PreparedStatement p=con.prepareStatement("select * from peca");
       rs=p.executeQuery();
       
       while(rs.next()){
          peca pe = new peca();
      pe.setIdpeca(rs.getInt("idpeca"));
            pe.setNome(rs.getString("nome"));
            pe.setQt_Estoque(rs.getInt("qt_estoque"));
            pe.setPreco_Unitario(rs.getDouble("preco_unitario"));
            
            pecas.add(pe);
       }
       return pecas;
   } 
   catch(SQLException erro){
       throw new RuntimeException(erro);
   }
}

}