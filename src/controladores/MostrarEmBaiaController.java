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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Heverton Gomes
 */
public class MostrarEmBaiaController implements Initializable {
    
    @FXML
    private BorderPane borderPrincipal;

    @FXML
    private TableView<?> tableIdePorcos;

    @FXML
    private TableColumn<?, ?> idPorcos;

    @FXML
    private TableColumn<?, ?> idBaias;

    @FXML
    private JFXButton btVoltar;

 
     @FXML
    private void voltarBaias(){
        
        try {
            Parent baia = FXMLLoader.load(getClass().getResource("/visao/TelaTrocaBaia.fxml"));
            borderPrincipal.setCenter(baia);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}

