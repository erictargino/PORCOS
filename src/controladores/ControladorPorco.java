/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelos.Suino;
import persistencia.SuinoDAO;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorPorco implements Initializable {

    @FXML
    private BorderPane borderPorco;
    @FXML
    private VBox VboxPorco;
    @FXML
    private JFXTextField CP_id;
    @FXML
    private JFXTextField CP_nome;
    @FXML
    private JFXTextField CP_nasc;
    @FXML
    private JFXTextField CP_aquisicao;
    @FXML
    private JFXButton CP_remover;
    @FXML
    private JFXButton CP_cadastro;
    @FXML
    private JFXButton CP_editar;
    @FXML
    private JFXButton Voltar;
    
    private SuinoDAO suinos = new SuinoDAO();
    private Suino porco;
    
    @FXML
    private void voltarMenu(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/Tela_Principal.fxml"));
            borderPorco.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private void limpar(){
        CP_nome.clear();
        CP_id.clear();
        CP_nasc.clear();
        CP_aquisicao.clear();
    }
    
    @FXML
    private void addPorco() throws ParseException{
        
        int id = Integer.parseInt(CP_id.getText());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date data_nasc = new java.sql.Date(format.parse(CP_nasc.getText()).getTime());
        java.sql.Date data_aqui = new java.sql.Date(format.parse(CP_aquisicao.getText()).getTime());

        
        porco = new Suino(id,CP_nome.getText(),data_nasc, data_aqui);
        suinos.insertPorco(porco);
        limpar();
    }
    
    @FXML
    private void atualizarPorco(){
        
        System.out.println(CP_nome.getText());
        String novoNome = CP_nome.getText();
        suinos.updatePorco(novoNome, porco);
        limpar();
    }
    
    @FXML 
    private void removerPorco(){
        
        int id = Integer.parseInt(CP_id.getText());
        suinos.deletePorco(id);
        limpar();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
