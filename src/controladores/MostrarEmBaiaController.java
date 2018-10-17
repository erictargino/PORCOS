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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import modelos.Baia;
import modelos.PorcoEmBaia;
import modelos.Suino;
import persistencia.BaiaDAO;
import persistencia.PorcoEmBaiaDAO;
import persistencia.SuinoDAO;

/**
 * FXML Controller class
 *
 * @author Heverton Gomes
 */
public class MostrarEmBaiaController implements Initializable {
    
    
    private PorcoEmBaiaDAO pb = new PorcoEmBaiaDAO();
    
    private SuinoDAO sui = new SuinoDAO();
    
    private BaiaDAO bai = new BaiaDAO();
    
    private ObservableList<PorcoEmBaia> porcoembaia = FXCollections.observableArrayList();
	
    private ObservableList<Suino> suino = FXCollections.observableArrayList();
	
    private ObservableList<Baia> baia = FXCollections.observableArrayList();
    
    @FXML
    private BorderPane borderPrincipal;

    @FXML
    private TableView<PorcoEmBaia> tableIdePorcos;

    @FXML
    private TableColumn<Suino, Integer> ColunaIdPorcos;

    @FXML
    private TableColumn<Baia, Integer> ColunaIdidBaias;

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
    
    @FXML
    private void buscarPorcoEmBaia(){
        
        /*
        porcoembaia.addAll(pb.listPorcoEmBaia());
        tableIdePorcos.setItems(porcoembaia);
        ColunaIdPorcos.setCellValueFactory(new  PropertyValueFactory<Suino, Integer>("id"));
        ColunaIdidBaias.setCellValueFactory(new  PropertyValueFactory<Baia, Integer>("id"));
        */
        
        ObservableList<PorcoEmBaia> porcoList = FXCollections.observableArrayList(pb.listPorcoEmBaia());
        tableIdePorcos.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id_porco"));
        tableIdePorcos.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("id_baia"));
        tableIdePorcos.setItems(porcoList);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscarPorcoEmBaia();
        // TODO
    }    
    
    
    
}

