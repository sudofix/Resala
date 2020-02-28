/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class mainController implements Initializable {

    @FXML
    private AnchorPane shifterPane;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane headerPane;

    @FXML
    private JFXHamburger hamb;

    @FXML
    private VBox sider;

    @FXML
    private JFXButton drawerUserbtn;
    @FXML
    private JFXButton drawerHomebtn;

    @FXML
    private JFXButton drawerNewbtn;

    @FXML
    private JFXButton drawerQuerybtn;

    @FXML
    private JFXButton aboutbtn;

    @FXML
    void openAboutpane(ActionEvent event) throws Exception{
        aboutbtn.setStyle("-fx-background-color : #00AEBC;");
        drawerUserbtn.setStyle("-fx-background-color : transparent;");
        drawerHomebtn.setStyle("-fx-background-color : transparent;");
        drawerNewbtn.setStyle("-fx-background-color : transparent;");
        drawerQuerybtn.setStyle("-fx-background-color : transparent;");
        drawer.close();
        drawer.toBack();
        AnchorPane input = FXMLLoader.load(getClass().getResource("about.fxml"));
        shifterPane.getChildren().setAll(input);

    }

    @FXML
    void openHomepane(ActionEvent event) throws Exception{
        aboutbtn.setStyle("-fx-background-color : transparent;");
        drawerUserbtn.setStyle("-fx-background-color : transparent;");
        drawerHomebtn.setStyle("-fx-background-color : #00AEBC;");
        drawerNewbtn.setStyle("-fx-background-color : transparent;");
        drawerQuerybtn.setStyle("-fx-background-color : transparent;");
        drawer.close();
        drawer.toBack();
        AnchorPane input = FXMLLoader.load(getClass().getResource("home.fxml"));
        shifterPane.getChildren().setAll(input);

    }

    @FXML
    void openNewpane(ActionEvent event) throws Exception {
        aboutbtn.setStyle("-fx-background-color : transparent;");
        drawerUserbtn.setStyle("-fx-background-color : transparent;");
        drawerHomebtn.setStyle("-fx-background-color : transparent;");
        drawerNewbtn.setStyle("-fx-background-color : #00AEBC;");
        drawerQuerybtn.setStyle("-fx-background-color : transparent;");
        drawer.close();

        drawer.toBack();
        JFXTabPane input = FXMLLoader.load(getClass().getResource("input.fxml"));
        shifterPane.getChildren().setAll(input);

    }

    @FXML
    void openQuerypane(ActionEvent event) throws Exception{
        aboutbtn.setStyle("-fx-background-color : transparent;");
        drawerUserbtn.setStyle("-fx-background-color : transparent;");
        drawerHomebtn.setStyle("-fx-background-color : transparent;");
        drawerNewbtn.setStyle("-fx-background-color : transparent;");
        drawerQuerybtn.setStyle("-fx-background-color : #00AEBC;");
        drawer.close();
        drawer.toBack();
        JFXTabPane input = FXMLLoader.load(getClass().getResource("Query.fxml"));
        shifterPane.getChildren().setAll(input);

    }

    @FXML
    void openUserpane(ActionEvent event) throws Exception {
        aboutbtn.setStyle("-fx-background-color : transparent;");
        drawerUserbtn.setStyle("-fx-background-color : #00AEBC;");
        drawerHomebtn.setStyle("-fx-background-color : transparent;");
        drawerNewbtn.setStyle("-fx-background-color : transparent;");
        drawerQuerybtn.setStyle("-fx-background-color : transparent;");
        AnchorPane input = FXMLLoader.load(getClass().getResource("users.fxml"));
        shifterPane.getChildren().setAll(input);
        drawer.close();

        drawer.toBack();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        drawer.toBack();
        HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamb);
        burgerTask.setRate(-1);
        hamb.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask.setRate(burgerTask.getRate() * - 1);
            burgerTask.play();
            if (drawer.isOpened()) {
                drawer.close();
                drawer.toBack();
            } else {
                drawer.toFront();
                drawer.open();

            }
        });

        try {
            AnchorPane input = FXMLLoader.load(getClass().getResource("home.fxml"));
            shifterPane.getChildren().setAll(input);
            // Scene sscene = new Scene(second);
            //Stage window = (Stage) (shifterPane.getScene().getRoot());
            //window.setScene(sscene);
            //shifterPane.getScene()
            // VBox d = FXMLLoader.load(getClass().getResource("drawer.fxml"));
            drawer.setSidePane(sider);

        } catch (Exception ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
