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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import modelos.PorcoEmBaia;
import modelos.Suino;
import persistencia.SuinoDAO;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class VizualizarPorcoController implements Initializable {

    @FXML
    private BorderPane borderPrincipal;
    
    @FXML
    private TableView<Suino> tabelaPorco;
    @FXML
    private JFXButton voltarPorco;
    
    private SuinoDAO dao = new SuinoDAO();
    
    @FXML
    private void voltarMenu(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/TelaCadastro.fxml"));
            borderPrincipal.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    private void visualizar(){
        
        ObservableList<Suino> porcoList = FXCollections.observableArrayList(dao.listarSuino());
        tabelaPorco.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id"));
        tabelaPorco.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("nome"));
        tabelaPorco.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("data_nasc"));
        tabelaPorco.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("data_aqui"));
        tabelaPorco.setItems(porcoList);
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        visualizar();
        // TODO
    }    
    
}
