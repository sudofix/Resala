/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class UsersController implements Initializable {

    @FXML
    private JFXTreeTableView<User> table;
    @FXML
    private JFXTextField newusername;
    @FXML
    private JFXButton newuserbtn;
    @FXML
    private JFXPasswordField newpass;

    /**
     * Initializes the controller class.
     */
   URL url;
   ResourceBundle rb;
    @FXML
    private JFXTreeTableColumn<User,String> password;
    @FXML
    private JFXTreeTableColumn<User,String> userName;
    @FXML
    private JFXTextField usersearch;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.rb = rb;
        // TODO
        
        userName.setPrefWidth(150);
        userName.setCellValueFactory((TreeTableColumn.CellDataFeatures<User,String> param) -> new SimpleStringProperty(param.getValue().getValue().user_name));
        
        password.setPrefWidth(150);
        password.setCellValueFactory((TreeTableColumn.CellDataFeatures<User,String> param) -> new SimpleStringProperty(param.getValue().getValue().password));
        try{
        ObservableList list = User.getAll();
        final TreeItem<User> root = new RecursiveTreeItem<User>(list,RecursiveTreeObject::getChildren);
        table.getColumns().setAll(userName,password);
        table.setRoot(root);
        table.setShowRoot(false);
        
        }
        catch(Exception e){}
        table.setEditable(true);
        password.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        password.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<User, String>>(){
        @Override
        public void handle(TreeTableColumn.CellEditEvent<User, String> event) {
            
            TreeItem<User> curr = table.getTreeItem(event.getTreeTablePosition().getRow());
            curr.getValue().password = event.getNewValue();
            try{
            User.Update(curr.getValue());}
            catch(Exception e){}
            
        }
    });
        
      usersearch.textProperty().addListener((o, oldVal, newVal) -> {
            table.setPredicate(userProp -> {
                final User user = userProp.getValue();
                return user.user_name.contains(newVal);
            });
        });
    }    

    @FXML
    private void addNewUser(ActionEvent event) throws Exception{
        User u = new User(newusername.getText(),newpass.getText());
        u.Store();
        this.initialize(url,rb);
    }

    @FXML
    private void search(InputMethodEvent event) {
        
    }
    
}
