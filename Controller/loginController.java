/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class loginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private AnchorPane loginPane;
    @FXML
    private JFXTextField user_nameText;

    @FXML
    private JFXPasswordField passwordText;

    @FXML
    private JFXButton loginBtn;
    @FXML
    private StackPane stackpane;

    @FXML
    void loginButtonClicked(ActionEvent event) throws Exception {

        if (        User.isCorrect(user_nameText.getText(), passwordText.getText())) {
            ((Stage) loginBtn.getScene().getWindow()).close();

            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = new Stage();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } else {

            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            dialogLayout.setBody(new Text(10, 10, "Wrong Data"));

            JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);
            dialog.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] s = {"admin", "user", "resala"};
        TextFields.bindAutoCompletion(user_nameText, s);

    }

}
