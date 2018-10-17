/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Heverton
 */
public class Conexao {
    
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgre";
    private static final String CAMINHO = "jdbc:postgresql://localhost:5432/sistemas_porcos";//mudar LOCAL HOST quando for usar em outro locais COM PGADIN EM CASA É 5433
    private static final String DRIVER = "org.postgresql.Driver";
    private Connection conexao;
    
    
    public void conecta(){
        System.out.println(CAMINHO);
        try {
                Class.forName(DRIVER);
                conexao = DriverManager.getConnection(CAMINHO, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    public void desconecta(){
        
        try{
                conexao.close();
        }catch(SQLException e){
             System.err.println(e);
        }  
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
}