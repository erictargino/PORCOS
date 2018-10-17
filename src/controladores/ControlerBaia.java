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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import modelos.Baia;
import persistencia.BaiaDAO;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControlerBaia implements Initializable {

    @FXML
    private BorderPane borderCbaia;
    @FXML
    private JFXTextField CB_id;
    @FXML
    private JFXTextField CB_nome;
    @FXML
    private JFXTextField CB_limpo;
    @FXML
    private JFXButton CB_cadastro;
    @FXML
    private JFXButton CB_remover;
    @FXML
    private JFXButton CB_cadastro2;
    @FXML
    private JFXButton Voltar;
    
    private Baia baia;
    
    private BaiaDAO bdbaia = new BaiaDAO();
    
     @FXML
     private void voltarMenu2(){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/Tela_Principal.fxml"));
             borderCbaia.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
     private void limpar(){
         CB_nome.clear();
         CB_id.clear();
         CB_limpo.clear();
     }
     
     
    @FXML
    private void addBaia(){
        
        int id = Integer.parseInt(CB_id.getText());
        Double tam = Double.parseDouble(CB_nome.getText());
        
        baia = new Baia(id,tam,CB_limpo.getText());
        bdbaia.insertPorco(baia);
        limpar();
    }
    
    @FXML
    private void atualizarBaia(){
        
        int id = Integer.parseInt(CB_id.getText());
        bdbaia.updateBaia(CB_limpo.getText(), id);
        limpar();
        
    }
    
    @FXML
    private void removerBaia(){
        
        int id = Integer.parseInt(CB_id.getText());
        bdbaia.deletePorco(id);
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
