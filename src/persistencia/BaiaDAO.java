/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import modelos.Baia;
import modelos.Suino;

/**
 *
 * @author Heverton
 */
public class BaiaDAO {
    private final Conexao con = new Conexao();
    
    private final String INSERIRBAIA = "INSERT INTO baia(id, tamanho,indicador_limpeza) VALUES (?, ?, ?);";
    private final String UPDATEBAIA = "UPDATE BAIA SET NOME = ? WHERE NOME = ?";
    private final String DELETEBAIA = "Delete from baia WHERE ID = ? ;";
    private final String LISTARBAIA = "SELECT * FROM BAIA;";
    
     public boolean insertPorco(Baia ba){
      
     try{   
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(INSERIRBAIA);
        
        preparaInstrucao.setInt(1, ba.getId());
        preparaInstrucao.setDouble(2, ba.getTamanho());
        preparaInstrucao.setString(3, ba.isBaiaLimpa());
        
        
        preparaInstrucao.execute();
        
        con.desconecta();
        
        return true;
        
     }catch(SQLException e){
         return false;
     }   
        
    }

    public boolean updateBaia(Double tamanho, Baia ba){
      
     try{   
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(UPDATEBAIA);
        
        preparaInstrucao.setDouble(1, tamanho);
        preparaInstrucao.setDouble(2, ba.getTamanho());
        
        preparaInstrucao.execute();
        
        con.desconecta();
        
        return true;
        
     }catch(SQLException e){
         return false;
     }   
        
    }
    
   public boolean deletePorco(Baia ba){
      
     try{   
         
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(DELETEBAIA);
       
        preparaInstrucao.setInt(1, ba.getId());
        
        preparaInstrucao.execute();
        
        con.desconecta();
        
        return true;
        
     }catch(SQLException e){
         return false;
     }   
        
    }
   
   public ArrayList<Baia> listarBaia(){
        
        ArrayList<Baia> lista = new ArrayList<>();
    
    try{
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(LISTARBAIA);
        
        ResultSet rs = preparaInstrucao.executeQuery();
        
        while(rs.next()){
            Baia s = new Baia(rs.getInt("id"), rs.getDouble("tamanho"), rs.getString("indicador_limpeza"));
            lista.add(s);
        }
        
        con.desconecta();
        
    }catch(SQLException e){ 
        e.printStackTrace();
    }    
        Collections.sort(lista);
        return lista;
    }
    
    
}
