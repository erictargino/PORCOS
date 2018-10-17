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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelos.PorcoEmBaia;
import persistencia.PorcoEmBaiaDAO;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorPorcoBaia implements Initializable {

    @FXML
    private BorderPane borderBaia;
    @FXML
    private VBox VboxControleBaias;
    @FXML
    private JFXTextField Controle_id;
    @FXML
    private JFXTextField Controle_idPorco;
    @FXML
    private JFXTextField Controle_idBaia;
    @FXML
    private Label Controle_msg;
    @FXML
    private JFXButton Controle_add;
    @FXML
    private JFXButton Controle_retirar;
    @FXML
    private JFXButton Controle_trocar;
    @FXML
    private JFXButton Voltar;
    
    private PorcoEmBaiaDAO pb = new PorcoEmBaiaDAO();
    
    private PorcoEmBaia pbaia;

    
    @FXML  
    private void voltarMenu3(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/Tela_Principal.fxml"));
            borderBaia.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

     @FXML  
    private void mostrarPB(){
        
        try {
            Parent pb = FXMLLoader.load(getClass().getResource("/visao/MostrarEmBaia.fxml"));
            borderBaia.setCenter(pb);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void limpar(){
        Controle_id.clear();
        Controle_idPorco.clear();
        Controle_idBaia.clear();
    }
    
    @FXML
    private void addPorcoEmBaia(){
        
        int id = Integer.parseInt(Controle_id.getText());
        int id_porco = Integer.parseInt(Controle_idPorco.getText());
        int id_baia = Integer.parseInt(Controle_idBaia.getText());
        
        pbaia = new PorcoEmBaia(id,id_porco,id_baia);
        
        pb.insertPorcoEmBaia(pbaia);
        limpar();
        
    }
    
    @FXML
    private void trocarPorcoDeBaia(){
        
        int id = Integer.parseInt(Controle_id.getText());
        int id_baia = Integer.parseInt(Controle_idBaia.getText());
        
        pb.updatePorcoEmBaia(id_baia, id);
        limpar();
    }
    
    @FXML
    private void tirarPorcoDeBaia(){
        
        int id = Integer.parseInt(Controle_id.getText());
        pb.deleteAutor(id);
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
