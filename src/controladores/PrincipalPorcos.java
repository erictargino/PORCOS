/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class PrincipalPorcos {

    @FXML
    private BorderPane borderPrincipal;
    
    @FXML
    private VBox VboxPrincipal;

    @FXML
    private JFXButton Porco;

    @FXML
    private JFXButton Baias;

    @FXML
    private JFXButton MostrarBaias;
            
       
    

    @FXML
    private void cadastrarPorcos(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/TelaCadastro.fxml"));
            borderPrincipal.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    private void cadastrarBaias(){
        
        try {
            Parent baia = FXMLLoader.load(getClass().getResource("/visao/TelaBaia.fxml"));
            borderPrincipal.setCenter(baia);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    private void cadastrarPorcosNaBaia(){
        
        try {
            Parent pb = FXMLLoader.load(getClass().getResource("/visao/TelaTrocaBaia.fxml"));
            borderPrincipal.setCenter(pb);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
