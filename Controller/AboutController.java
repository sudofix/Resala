/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class AboutController implements Initializable {

    @FXML
    private JFXTextArea sql;
    @FXML
    private JFXButton sqlbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void executesql(ActionEvent event) throws Exception {
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement(sql.getText());
        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData rsmd = resultSet.getMetaData();
        String s = "";
        sql.clear();

        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    sql.setText(sql.getText() + " "+",  ");
                }
                String columnValue = resultSet.getString(i);
                sql.setText(sql.getText() + " " +columnValue + " " + rsmd.getColumnName(i));
            }
            sql.setText(sql.getText() + " " + "\n");
        }
        //System.out.println(s);
       // sql.setText(s);
    }

}
