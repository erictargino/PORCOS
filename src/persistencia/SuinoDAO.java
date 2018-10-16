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
import modelos.Suino;

/**
 *
 * @author Heverton
 */
public class SuinoDAO {
    private final Conexao con = new Conexao();
    
    private final String INSERIRPORCO = "INSERT INTO porco(id, nome, data_nasc,data_aqui) VALUES (?, ?, ?,?);";
    private final String UPDATEPORCO = "UPDATE PORCO SET NOME = ? WHERE NOME = ?";
    private final String DELETEPORCO = "Delete from porco WHERE ID = ? ;";
    private final String LISTARPORCOS = "SELECT * FROM PORCO;";
    
    public boolean insertPorco(Suino su){
      
     try{   
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(INSERIRPORCO);
        
        preparaInstrucao.setInt(1, su.getId());
        preparaInstrucao.setString(2, su.getNome().toUpperCase());
        preparaInstrucao.setDate(3, su.getData_nasc());
        preparaInstrucao.setDate(4, su.getData_aqui());
        
        preparaInstrucao.execute();
        
        con.desconecta();
        
        return true;
        
     }catch(SQLException e){
         return false;
     }   
        
    }

    public boolean updatePorco(String nome, Suino su){
      
     try{   
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(UPDATEPORCO);
        
        preparaInstrucao.setString(1, nome.toUpperCase());
        preparaInstrucao.setString(2, su.getNome().toUpperCase());
        
        preparaInstrucao.execute();
        
        con.desconecta();
        
        return true;
        
     }catch(SQLException e){
         return false;
     }   
        
    }
    
    public boolean deletePorco(Suino su){
      
     try{   
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(DELETEPORCO);
       
        preparaInstrucao.setInt(1, su.getId());
        
        preparaInstrucao.execute();
        
        con.desconecta();
        
        return true;
        
     }catch(SQLException e){
         return false;
     }   
        
    }
    
    public ArrayList<Suino> listarSuino(){
        
        ArrayList<Suino> lista = new ArrayList<>();
    
    try{
        con.conecta();
        PreparedStatement preparaInstrucao;
	preparaInstrucao = con.getConexao().prepareStatement(LISTARPORCOS);
        
        ResultSet rs = preparaInstrucao.executeQuery();
        
        while(rs.next()){
            Suino s = new Suino(rs.getInt("ID"), rs.getString("NOME"), rs.getDate("DATA_NASC"), rs.getDate("DATA_AQUI"));
            lista.add(s);
        }
        con.desconecta();
    }catch(SQLException e){    
    }    
        Collections.sort(lista);
        return lista;
    }
    
}
