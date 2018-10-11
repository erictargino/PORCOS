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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
    
    @FXML
    private void voltarMenu(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/Tela_Principal.fxml"));
            borderPorco.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
