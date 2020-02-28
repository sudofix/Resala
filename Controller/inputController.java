/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import java.sql.*;
import java.util.ArrayList;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class inputController implements Initializable {

    @FXML
    private JFXTabPane inputTab;

    @FXML
    private JFXSlider rateSlider;

    @FXML
    private JFXButton next1;

    @FXML
    private JFXTextField idText;

    @FXML
    private JFXTextField area_codeText;

    @FXML
    private JFXTextField husband_nameText;

    @FXML
    private JFXTextField phoneText;

    @FXML
    private JFXTextField mobileText;

    @FXML
    private JFXTextField researcherText;

    @FXML
    private JFXTextField descriptionText;

    @FXML
    private JFXDatePicker research_dateDate;

    @FXML
    private JFXButton next2;

    @FXML
    private JFXTextField member1name;

    @FXML
    private JFXToggleButton membermarried1;

    @FXML
    private JFXTextField memberage1;

    @FXML
    private JFXTextField membereducation1;

    @FXML
    private JFXTextField memberid1;

    @FXML
    private JFXTextField memberjob1;

    @FXML
    private JFXTextField member2name;

    @FXML
    private JFXToggleButton membermarried2;

    @FXML
    private JFXTextField memberage2;

    @FXML
    private JFXTextField membereducation2;

    @FXML
    private JFXTextField memberid2;

    @FXML
    private JFXTextField memberjob2;

    @FXML
    private JFXTextField member3name;

    @FXML
    private JFXToggleButton membermarried3;

    @FXML
    private JFXTextField memberage3;

    @FXML
    private JFXTextField membereducation3;

    @FXML
    private JFXTextField memberid3;

    @FXML
    private JFXTextField memberjob3;

    @FXML
    private JFXTextField member4name;

    @FXML
    private JFXToggleButton membermarried4;

    @FXML
    private JFXTextField memberage4;

    @FXML
    private JFXTextField membereducation4;

    @FXML
    private JFXTextField memberid4;

    @FXML
    private JFXTextField memberjob4;

    @FXML
    private JFXTextField member5name;

    @FXML
    private JFXToggleButton membermarried5;

    @FXML
    private JFXTextField memberage5;

    @FXML
    private JFXTextField membereducation5;

    @FXML
    private JFXTextField memberid5;

    @FXML
    private JFXTextField memberjob6;

    @FXML
    private JFXTextField member6name;

    @FXML
    private JFXToggleButton membermarried6;

    @FXML
    private JFXTextField memberage6;

    @FXML
    private JFXTextField membereducation6;

    @FXML
    private JFXTextField memberid6;

    @FXML
    private JFXTextField member7name;

    @FXML
    private JFXToggleButton membermarried7;

    @FXML
    private JFXTextField memberage7;

    @FXML
    private JFXTextField membereducation7;

    @FXML
    private JFXTextField memberid7;

    @FXML
    private JFXTextField memberjob7;

    @FXML
    private JFXTextField member8name;

    @FXML
    private JFXToggleButton membermarried8;

    @FXML
    private JFXTextField memberage8;

    @FXML
    private JFXTextField membereducation8;

    @FXML
    private JFXTextField memberid8;

    @FXML
    private JFXTextField memberjob8;

    @FXML
    private JFXButton next3;

    @FXML
    private JFXButton next4;

    @FXML
    private JFXTextField incomevalue1;

    @FXML
    private JFXTextField incomedetail1;

    @FXML
    private JFXTextField incomevalue11;

    @FXML
    private JFXTextField incomedetail11;

    @FXML
    private JFXTextField incomevalue111;

    @FXML
    private JFXTextField incomedetail111;

    @FXML
    private JFXTextField incomevalue1111;

    @FXML
    private JFXTextField incomedetail1111;

    @FXML
    private JFXTextField incomevalue11111;

    @FXML
    private JFXTextField incomedetail11111;

    @FXML
    private JFXTextField incomevalue111111;

    @FXML
    private JFXTextField incomedetail111111;

    @FXML
    private JFXTextField incomevalue1111111;

    @FXML
    private JFXTextField incomedetail1111111;

    @FXML
    private JFXTextField incomevalue11111111;

    @FXML
    private JFXTextField incomedetail11111111;

    @FXML
    private JFXButton next5;

    @FXML
    private JFXTextField outcomevalue1;

    @FXML
    private JFXTextField outcomedetail1;

    @FXML
    private JFXTextField outcomevalue11;

    @FXML
    private JFXTextField outcomedetail11;

    @FXML
    private JFXTextField outcomevalue111;

    @FXML
    private JFXTextField outcomedetail111;

    @FXML
    private JFXTextField outcomevalue1111;

    @FXML
    private JFXTextField outcomedetail1111;

    @FXML
    private JFXTextField outcomevalue11111;

    @FXML
    private JFXTextField outcomedetail11111;

    @FXML
    private JFXTextField outcomevalue111111;

    @FXML
    private JFXTextField outcomedetail111111;

    @FXML
    private JFXTextField outcomevalue1111111;

    @FXML
    private JFXTextField outcomedetail1111111;

    @FXML
    private JFXTextField outcomevalue11111111;

    @FXML
    private JFXTextField outcomedetail11111111;

    @FXML
    private JFXButton next6;

    @FXML
    private JFXButton next7;

    @FXML
    private JFXButton store;
    @FXML
    private JFXTextField nameText;
    @FXML
    private JFXTextField memberjob5;
    ArrayList<JFXTextField> names = new ArrayList();
    ArrayList<JFXToggleButton> marrieds = new ArrayList();
    ArrayList<JFXTextField> ages = new ArrayList();
    ArrayList<JFXTextField> educations = new ArrayList();

    ArrayList<JFXTextField> natids = new ArrayList();
    ArrayList<JFXTextField> jobs = new ArrayList();
    @FXML
    private JFXRadioButton typeflat;
    @FXML
    private JFXRadioButton typevillage;
    @FXML
    private JFXRadioButton typecity;
    @FXML
    private JFXRadioButton typenest;
    @FXML
    private JFXRadioButton rentrent;
    @FXML
    private JFXRadioButton rentprivate;
    @FXML
    private JFXRadioButton rentstate;
    @FXML
    private JFXRadioButton rentshared;
    @FXML
    private JFXRadioButton areasuburbs;
    @FXML
    private JFXRadioButton areavillage;
    @FXML
    private JFXRadioButton areacity;
    @FXML
    private JFXRadioButton areabadu;
    @FXML
    private JFXTextField rooms;
    @FXML
    private JFXTextField floors;
    @FXML
    private JFXRadioButton buildingpainting;
    @FXML
    private JFXRadioButton buildingconcrete;
    @FXML
    private JFXRadioButton buildingbrick;
    @FXML
    private JFXRadioButton buildingmud;
    @FXML
    private JFXRadioButton roofconcrete;
    @FXML
    private JFXRadioButton roofwood;
    @FXML
    private JFXSlider accrate;
    @FXML
    private JFXTextArea opinion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        area_codeText.setText("0");
        idText.setText("0");
        phoneText.setText("0");
        mobileText.setText("0");
        names.add(member1name);
        names.add(member2name);
        names.add(member3name);
        names.add(member4name);
        names.add(member5name);
        names.add(member6name);
        names.add(member7name);
        names.add(member8name);
        marrieds.add(membermarried1);
        marrieds.add(membermarried2);
        marrieds.add(membermarried3);
        marrieds.add(membermarried4);
        marrieds.add(membermarried5);
        marrieds.add(membermarried6);
        marrieds.add(membermarried7);
        marrieds.add(membermarried8);
        ages.add(memberage1);
        ages.add(memberage2);
        ages.add(memberage3);
        ages.add(memberage4);
        ages.add(memberage5);
        ages.add(memberage6);
        ages.add(memberage7);
        ages.add(memberage8);

        educations.add(membereducation1);
        natids.add(memberid1);
        jobs.add(memberjob1);
        educations.add(membereducation2);
        natids.add(memberid2);
        jobs.add(memberjob2);
        educations.add(membereducation3);
        natids.add(memberid3);
        jobs.add(memberjob3);
        educations.add(membereducation4);
        natids.add(memberid4);
        jobs.add(memberjob4);
        educations.add(membereducation5);
        natids.add(memberid5);
        jobs.add(memberjob5);
        educations.add(membereducation6);
        natids.add(memberid6);
        jobs.add(memberjob6);
        educations.add(membereducation7);
        natids.add(memberid7);
        jobs.add(memberjob7);
        educations.add(membereducation8);
        natids.add(memberid8);
        jobs.add(memberjob8);

        for (int i = 0; i < 8; i++) {
            //ages.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));
            // ages.get(i).getValueFactory().setValue(1);
            ages.get(i).setText("0");
        }

    }

    @FXML
    void moveNextTab(ActionEvent event) {
        inputTab.getSelectionModel().selectNext();

    }

    @FXML
    void storeDatabase(ActionEvent event) throws Exception {

        Family f = new Family(Integer.parseInt(area_codeText.getText()), (int) (rateSlider.getValue()), Integer.parseInt(idText.getText()), nameText.getText(), husband_nameText.getText(), Integer.parseInt(phoneText.getText()), Integer.parseInt(mobileText.getText()), Date.valueOf(research_dateDate.getValue()), researcherText.getText(), descriptionText.getText());

        try {
            f.Store();
        } catch (Exception e) {
        }

        for (int i = 0; i < 8 && !"".equals(natids.get(i).getText()); i++) {
            //ages.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));
            // ages.get(i).getValueFactory().setValue(1);
            ages.get(i).setText("0");
            Family_Member fm = new Family_Member(names.get(i).getText(), Integer.parseInt(ages.get(i).getText()), marrieds.get(i).isSelected(), educations.get(i).getText(), jobs.get(i).getText(), Integer.parseInt(natids.get(i).getText()), Integer.parseInt(idText.getText()));
            try {
                fm.Store();
            } catch (Exception x) {

            }
        }

    }

}
