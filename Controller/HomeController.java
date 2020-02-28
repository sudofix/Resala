/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class HomeController implements Initializable {

    @FXML
    private JFXTextField repid;
    @FXML
    private JFXButton repbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void generatereport(ActionEvent event) throws Exception {
        Connection conn = DB.get();
        int id = Integer.parseInt(repid.getText());
//       // String s;
//        JasperDesign design = JRXmlLoader.load("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\Test1\\src\\test1\\report1.jrxml");
//        JRDesignQuery query = new JRDesignQuery();
//        query.setText("SELECT\n"
//                + "     FAMILY.\"AREA_CODE\" AS FAMILY_AREA_CODE,\n"
//                + "     FAMILY.\"RATE\" AS FAMILY_RATE,\n"
//                + "     FAMILY.\"ID\" AS FAMILY_ID,\n"
//                + "     FAMILY.\"NAME\" AS FAMILY_NAME,\n"
//                + "     FAMILY.\"HUSBAND_NAME\" AS FAMILY_HUSBAND_NAME,\n"
//                + "     FAMILY.\"PHONE\" AS FAMILY_PHONE,\n"
//                + "     FAMILY.\"MOBILE\" AS FAMILY_MOBILE,\n"
//                + "     FAMILY.\"RESEARCH_DATE\" AS FAMILY_RESEARCH_DATE,\n"
//                + "     FAMILY.\"RESEARCHER\" AS FAMILY_RESEARCHER,\n"
//                + "     FAMILY.\"CASE_DESCRIPTION\" AS FAMILY_CASE_DESCRIPTION,\n"
//                + "     ACCOMMODATION.\"TYPE\" AS ACCOMMODATION_TYPE,\n"
//                + "     ACCOMMODATION.\"RENT\" AS ACCOMMODATION_RENT,\n"
//                + "     ACCOMMODATION.\"AREA\" AS ACCOMMODATION_AREA,\n"
//                + "     ACCOMMODATION.\"FLOORS\" AS ACCOMMODATION_FLOORS,\n"
//                + "     ACCOMMODATION.\"ROOMS\" AS ACCOMMODATION_ROOMS,\n"
//                + "     ACCOMMODATION.\"ROOF\" AS ACCOMMODATION_ROOF,\n"
//                + "     ACCOMMODATION.\"BATHROOM\" AS ACCOMMODATION_BATHROOM,\n"
//                + "     ACCOMMODATION.\"BUILD\" AS ACCOMMODATION_BUILD,\n"
//                + "     ACCOMMODATION.\"RATE\" AS ACCOMMODATION_RATE,\n"
//                + "     ACCOMMODATION.\"WATER_ID\" AS ACCOMMODATION_WATER_ID,\n"
//                + "     ACCOMMODATION.\"ELECTRICITY_ID\" AS ACCOMMODATION_ELECTRICITY_ID,\n"
//                + "     ACCOMMODATION.\"OPINION\" AS ACCOMMODATION_OPINION,\n"
//                + "     ACCOMMODATION.\"FAMILY_ID\" AS ACCOMMODATION_FAMILY_ID,\n"
//                + "     FAMILY_MEMBERS.\"NAME\" AS FAMILY_MEMBERS_NAME,\n"
//                + "     FAMILY_MEMBERS.\"AGE\" AS FAMILY_MEMBERS_AGE,\n"
//                + "     FAMILY_MEMBERS.\"MARRIED\" AS FAMILY_MEMBERS_MARRIED,\n"
//                + "     FAMILY_MEMBERS.\"EDUCATION\" AS FAMILY_MEMBERS_EDUCATION,\n"
//                + "     FAMILY_MEMBERS.\"JOB\" AS FAMILY_MEMBERS_JOB,\n"
//                + "     FAMILY_MEMBERS.\"NATIONAL_ID\" AS FAMILY_MEMBERS_NATIONAL_ID,\n"
//                + "     FAMILY_MEMBERS.\"FAMILY_ID\" AS FAMILY_MEMBERS_FAMILY_ID\n"
//                + "FROM\n"
//                + "     \"RESALA\".\"FAMILY\" FAMILY INNER JOIN \"RESALA\".\"ACCOMMODATION\" ACCOMMODATION ON FAMILY.\"ID\" = ACCOMMODATION.\"FAMILY_ID\"\n"
//                + "     INNER JOIN \"RESALA\".\"FAMILY_MEMBERS\" FAMILY_MEMBERS ON FAMILY.\"ID\" = FAMILY_MEMBERS.\"FAMILY_ID\"\n"
//                + "WHERE\n"
//                + "     FAMILY.\"ID\" = " + id);
//        design.setQuery(query);
        Map parameters = new HashMap();
      
      parameters.put("ID", id);
        JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\Test1\\src\\test1\\report1.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
        JasperViewer.viewReport(print, false);

    }

}
