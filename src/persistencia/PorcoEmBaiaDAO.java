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
import modelos.PorcoEmBaia;

/**
 *
 * @author Heverton
 */
public class PorcoEmBaiaDAO {
    
    private Conexao con = new Conexao();
    
    private final String INSERIRPORCOEMBAIA = "INSERT INTO porco_na_baia(id, id_porco, id_baia) VALUES (?,?, ?);";
    private final String UPDATEPORCOEMBAIA = "UPDATE porco_na_baia SET ID_BAIA = ? WHERE ID = ?";
    private final String DELETEPORCOEMBAIA = "Delete from porco_na_baia WHERE ID = ? ;";
    private final String LISTARPORCOEMBAIS = "SELECT * FROM BAIA";
    
    
    public boolean insertPorcoEmBaia(PorcoEmBaia pe){
            try{
                        
                        con.conecta();
                        PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERIRPORCOEMBAIA);
			
			preparaInstrucao.setInt(1, pe.getId());
			preparaInstrucao.setInt(2, pe.getId_porco());
                        preparaInstrucao.setInt(3, pe.getId_baia());
                        
			preparaInstrucao.execute();

			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean updatePorcoEmBaia(int id, int id_principal) {
		try {
			
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATEPORCOEMBAIA);

			preparaInstrucao.setInt(1, id);
			preparaInstrucao.setInt(2,id_principal);

			preparaInstrucao.execute();

			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
 
    public boolean deleteAutor(int id){
		try {
		
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETEPORCOEMBAIA);

			preparaInstrucao.setInt(1,id);

			preparaInstrucao.execute();

			con.desconecta();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
    public ArrayList<PorcoEmBaia> listPorcoEmBaia() {
		ArrayList<PorcoEmBaia> lista = new ArrayList<>(); 

		try {
			
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(LISTARPORCOEMBAIS); 

			ResultSet rs = preparaInstrucao.executeQuery(); 
	
			while (rs.next()) { 
				PorcoEmBaia a = new PorcoEmBaia(rs.getInt("id"), rs.getInt("id_porco"), rs.getInt("id_baia"));
				lista.add(a); 
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.sort(lista);
		return lista;
	}
}
