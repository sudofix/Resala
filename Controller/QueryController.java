/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javax.swing.event.ChangeListener;

public class QueryController implements Initializable {

    @FXML
    private JFXTreeTableView<Family> familytable;

    @FXML
    private TreeTableColumn<Family, String> idcolumn;

    @FXML
    private TreeTableColumn<Family, String> areacodecolumn;

    @FXML
    private TreeTableColumn<Family, String> husbandnamecolumn;

    @FXML
    private TreeTableColumn<Family, String> phonecolumn;

    @FXML
    private TreeTableColumn<Family, String> mobilecolumn;

    @FXML
    private TreeTableColumn<Family, String> descriptioncolumn;

    @FXML
    private TreeTableColumn<Family, String> namecolumn;

    @FXML
    private TreeTableColumn<Family, String> researchercolumn;

    @FXML
    private TreeTableColumn<Family, String> ratecolumn;

    @FXML
    private TreeTableColumn<Family, String> datecolumn;
    @FXML
    private TextField familyinput;
    @FXML
    private JFXTreeTableView<Family_Member> membertable;

    @FXML
    private TreeTableColumn<Family_Member, String> membername;

    @FXML
    private TreeTableColumn<Family_Member, String> memberage;

    @FXML
    private TreeTableColumn<Family_Member, String> membermarried;

    @FXML
    private TreeTableColumn<Family_Member, String> membereducation;

    @FXML
    private TreeTableColumn<Family_Member, String> memberjob;

    @FXML
    private TreeTableColumn<Family_Member, String> memberid;

    @FXML
    private TreeTableColumn<Family_Member, String> memberfamilyid;

    @FXML
    private TextField membersearch;

    @FXML
    private JFXTreeTableView<Accommodation> accommodationtable;

    @FXML
    private TreeTableColumn<Accommodation, String> acctype;

    @FXML
    private TreeTableColumn<Accommodation, String> accrent;

    @FXML
    private TreeTableColumn<Accommodation, String> accarea;

    @FXML
    private TreeTableColumn<Accommodation, String> accfloors;

    @FXML
    private TreeTableColumn<Accommodation, String> accrooms;

    @FXML
    private TreeTableColumn<Accommodation, String> accroof;

    @FXML
    private TreeTableColumn<Accommodation, String> accbathroom;

    @FXML
    private TreeTableColumn<Accommodation, String> accbuild;

    @FXML
    private TreeTableColumn<Accommodation, String> accrate;

    @FXML
    private TreeTableColumn<Accommodation, String> accwater;

    @FXML
    private TreeTableColumn<Accommodation, String> accelectricity;

    @FXML
    private TreeTableColumn<Accommodation, String> accopinion;

    @FXML
    private TreeTableColumn<Accommodation, String> accfamilyid;

    @FXML
    private TextField accsearch;

    @FXML
    private JFXTreeTableView<Income> incometable;

    @FXML
    private TreeTableColumn<Income, String> incomevalue;

    @FXML
    private TreeTableColumn<Income, String> incomedetails;

    @FXML
    private TreeTableColumn<Income, String> incomefamilyid;

    @FXML
    private TextField incomesearch;

    @FXML
    private JFXTreeTableView<Outcome> outcometable;

    @FXML
    private TreeTableColumn<Outcome, String> outcomevalue;

    @FXML
    private TreeTableColumn<Outcome, String> outcomedetails;

    @FXML
    private TreeTableColumn<Outcome, String> outcomefamilyid;

    @FXML
    private TextField outcomesearch;

    @FXML
    private JFXTreeTableView<Family_Need> needtable;

    @FXML
    private TreeTableColumn<Family_Need, String> needneed;

    @FXML
    private TreeTableColumn<Family_Need, String> needavailability;

    @FXML
    private TreeTableColumn<Family_Need, String> needfamilyid;

    @FXML
    private TextField needsearch;

    @FXML
    private JFXTreeTableView<Outer_Support> supporttable;

    @FXML
    private TreeTableColumn<Outer_Support, String> supporttype;

    @FXML
    private TreeTableColumn<Outer_Support, String> supportvalue;

    @FXML
    private TreeTableColumn<Outer_Support, String> supportsource;

    @FXML
    private TreeTableColumn<Outer_Support, String> supportregularity;

    @FXML
    private TreeTableColumn<Outer_Support, String> supportnotes;

    @FXML
    private TreeTableColumn<Outer_Support, String> supportfamilyid;

    @FXML
    private TextField supportsearch;

    @FXML
    private JFXTreeTableView<Appliance> appliancetable;

    @FXML
    private TreeTableColumn<Appliance, String> appliancetype;

    @FXML
    private TreeTableColumn<Appliance, String> appliancestatus;

    @FXML
    private TreeTableColumn<Appliance, String> appliancefamilyid;

    @FXML
    private TextField appliancesearch;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initfamily();
        initmembers();
        initaccom();
        initincome();
        initoutcome();
        initneed();
        initappliance();
        initsupport();

    }

    public void initfamily() {
        idcolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().id)));
        areacodecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().area_code)));
        husbandnamecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(param.getValue().getValue().husband_name));
        phonecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().phone)));
        mobilecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().mobile)));
        descriptioncolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(param.getValue().getValue().description));
        namecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(param.getValue().getValue().nick_name));
        researchercolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(param.getValue().getValue().researcher));
        ratecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().rate)));
        datecolumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().research_date)));

        try {
            ObservableList list = Family.getAll();
            final TreeItem<Family> root = new RecursiveTreeItem<Family>(list, RecursiveTreeObject::getChildren);
            familytable.getColumns().setAll(idcolumn, areacodecolumn, husbandnamecolumn, phonecolumn, mobilecolumn, descriptioncolumn, namecolumn, researchercolumn, ratecolumn, datecolumn);
            familytable.setRoot(root);
            familytable.setShowRoot(false);

        } catch (Exception e) {
        }

        familyinput.textProperty().addListener((o, oldVal, newVal) -> {
            familytable.setPredicate(userProp -> {
                final Family user = userProp.getValue();
                return user.nick_name.contains(newVal)
                        || String.valueOf(user.area_code).contains(newVal)
                        || String.valueOf(user.description).contains(newVal)
                        || String.valueOf(user.husband_name).contains(newVal)
                        || String.valueOf(user.id).contains(newVal)
                        || String.valueOf(user.mobile).contains(newVal)
                        || String.valueOf(user.phone).contains(newVal)
                        || String.valueOf(user.rate).contains(newVal)
                        || String.valueOf(user.research_date).contains(newVal)
                        || String.valueOf(user.researcher).contains(newVal);
            });
        });
        
        
        familytable.setEditable(true);
        husbandnamecolumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        husbandnamecolumn.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Family, String>>(){
        @Override
        public void handle(TreeTableColumn.CellEditEvent<Family, String> event) {
            
            TreeItem<Family> curr = familytable.getTreeItem(event.getTreeTablePosition().getRow());
            curr.getValue().husband_name = event.getNewValue();
            try{
            Family.Update(curr.getValue());}
            catch(Exception e){}
            
        }
    });
        
        mobilecolumn.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        mobilecolumn.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Family, String>>(){
        @Override
        public void handle(TreeTableColumn.CellEditEvent<Family, String> event) {
            
            TreeItem<Family> curr = familytable.getTreeItem(event.getTreeTablePosition().getRow());
            curr.getValue().mobile = Integer.parseInt(event.getNewValue());
            try{
            Family.Update(curr.getValue());}
            catch(Exception e){}
            
        }
    });

    }

    public void initmembers() {
        membername.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().name)));
        memberage.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().age)));
        membermarried.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().married)));
        membereducation.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().education)));
        memberjob.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().job)));
        memberid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().national_id)));
        memberfamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Member, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Family_Member.getAll();
            final TreeItem<Family_Member> root = new RecursiveTreeItem<Family_Member>(list, RecursiveTreeObject::getChildren);
            membertable.getColumns().setAll(membername, memberage, membermarried, membereducation, memberjob, memberid, memberfamilyid);
            membertable.setRoot(root);
            membertable.setShowRoot(false);

        } catch (Exception e) {
        }

        membersearch.textProperty().addListener((o, oldVal, newVal) -> {
            membertable.setPredicate(userProp -> {
                final Family_Member user = userProp.getValue();
                return user.name.contains(newVal) || String.valueOf(user.family_id).contains(newVal)
                        || String.valueOf(user.national_id).contains(newVal)
                        || String.valueOf(user.age).contains(newVal)
                        || String.valueOf(user.education).contains(newVal)
                        || String.valueOf(user.job).contains(newVal)
                        || String.valueOf(user.married).contains(newVal);
                
            });
        });

    }

    public void initaccom() {
        acctype.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().type)));
        accrent.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().rent)));
        accarea.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().area)));
        accfloors.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().floors)));
        accrooms.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().rooms)));
        accroof.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().roof)));
        accbathroom.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().bathroom)));
        accbuild.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().build)));
        accrate.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().rate)));
        accwater.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().water_id)));
        accelectricity.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().electricity_id)));
        accopinion.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().opinion)));
        accfamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Accommodation, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Accommodation.getAll();
            final TreeItem<Accommodation> root = new RecursiveTreeItem<Accommodation>(list, RecursiveTreeObject::getChildren);
            accommodationtable.getColumns().setAll(acctype, accrent, accarea, accfloors, accrooms, accroof, accbathroom, accbuild, accrate, accwater, accelectricity, accopinion, accfamilyid);
            accommodationtable.setRoot(root);
            accommodationtable.setShowRoot(false);

        } catch (Exception e) {
        }

        accsearch.textProperty().addListener((o, oldVal, newVal) -> {
            accommodationtable.setPredicate(userProp -> {
                final Accommodation user = userProp.getValue();
                return user.type.contains(newVal)
                        || user.area.contains(newVal)
                        || user.bathroom.contains(newVal)
                        || user.build.contains(newVal)
                        || String.valueOf(user.electricity_id).contains(newVal)
                        || String.valueOf(user.water_id).contains(newVal)
                        || String.valueOf(user.family_id).contains(newVal)
                        || String.valueOf(user.rate).contains(newVal)
                        || String.valueOf(user.rooms).contains(newVal)
                        || String.valueOf(user.opinion).contains(newVal)
                        || String.valueOf(user.rent).contains(newVal)
                        || String.valueOf(user.roof).contains(newVal);

            });
        });
    }

    public void initincome() {
        incomevalue.setCellValueFactory((TreeTableColumn.CellDataFeatures<Income, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().value)));
        incomedetails.setCellValueFactory((TreeTableColumn.CellDataFeatures<Income, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().detail)));
        incomefamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Income, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Income.getAll();
            final TreeItem<Income> root = new RecursiveTreeItem<Income>(list, RecursiveTreeObject::getChildren);
            incometable.getColumns().setAll(incomevalue, incomedetails, incomefamilyid);
            incometable.setRoot(root);
            incometable.setShowRoot(false);

        } catch (Exception e) {
        }

        incomesearch.textProperty().addListener((o, oldVal, newVal) -> {
            incometable.setPredicate(userProp -> {
                final Income user = userProp.getValue();
                return user.detail.contains(newVal)
                        || String.valueOf(user.family_id).contains(newVal)
                        || String.valueOf(user.value).contains(newVal);
            });
        });

    }

    public void initoutcome() {
        outcomevalue.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outcome, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().value)));
        outcomedetails.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outcome, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().detail)));
        outcomefamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outcome, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Outcome.getAll();
            final TreeItem<Outcome> root = new RecursiveTreeItem<Outcome>(list, RecursiveTreeObject::getChildren);
            outcometable.getColumns().setAll(outcomevalue, outcomedetails, outcomefamilyid);
            outcometable.setRoot(root);
            outcometable.setShowRoot(false);

        } catch (Exception e) {
        }

        incomesearch.textProperty().addListener((o, oldVal, newVal) -> {
            incometable.setPredicate(userProp -> {
                final Income user = userProp.getValue();
                return user.detail.contains(newVal)
                        || String.valueOf(user.family_id).contains(newVal)
                        || String.valueOf(user.value).contains(newVal);
            });
        });

    }

    public void initneed() {
        needneed.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Need, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().need)));
        needavailability.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Need, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().availability)));
        needfamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Family_Need, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Family_Need.getAll();
            final TreeItem<Family_Need> root = new RecursiveTreeItem<Family_Need>(list, RecursiveTreeObject::getChildren);
            needtable.getColumns().setAll(needneed, needavailability, needfamilyid);
            needtable.setRoot(root);
            needtable.setShowRoot(false);

        } catch (Exception e) {
        }

        needsearch.textProperty().addListener((o, oldVal, newVal) -> {
            needtable.setPredicate(userProp -> {
                final Family_Need user = userProp.getValue();
                return user.need.contains(newVal)
                        || String.valueOf(user.availability).contains(newVal);
            });
        });

    }

    public void initappliance() {
        appliancetype.setCellValueFactory((TreeTableColumn.CellDataFeatures<Appliance, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().type)));
        appliancestatus.setCellValueFactory((TreeTableColumn.CellDataFeatures<Appliance, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().status)));
        appliancefamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Appliance, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Appliance.getAll();
            final TreeItem<Appliance> root = new RecursiveTreeItem<Appliance>(list, RecursiveTreeObject::getChildren);
            appliancetable.getColumns().setAll(appliancetype, appliancestatus, appliancefamilyid);
            appliancetable.setRoot(root);
            appliancetable.setShowRoot(false);

        } catch (Exception e) {
        }

        appliancesearch.textProperty().addListener((o, oldVal, newVal) -> {
            appliancetable.setPredicate(userProp -> {
                final Appliance user = userProp.getValue();
                return user.type.contains(newVal)
                        || String.valueOf(user.family_id).contains(newVal)
                        || user.status.contains(newVal);
            });
        });

    }

    public void initsupport() {
        supporttype.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outer_Support, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().type)));
        supportvalue.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outer_Support, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().value)));
        supportsource.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outer_Support, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().source)));
        supportregularity.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outer_Support, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().regularity)));
        supportnotes.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outer_Support, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().notes)));
        supportfamilyid.setCellValueFactory((TreeTableColumn.CellDataFeatures<Outer_Support, String> param) -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().family_id)));

        try {
            ObservableList list = Outer_Support.getAll();
            final TreeItem<Outer_Support> root = new RecursiveTreeItem<Outer_Support>(list, RecursiveTreeObject::getChildren);
            supporttable.getColumns().setAll(supporttype, supportvalue, supportsource, supportregularity, supportnotes, supportfamilyid);
            supporttable.setRoot(root);
            supporttable.setShowRoot(false);

        } catch (Exception e) {
        }

        supportsearch.textProperty().addListener((o, oldVal, newVal) -> {
            supporttable.setPredicate(userProp -> {
                final Outer_Support user = userProp.getValue();
                return user.type.contains(newVal)
                        || String.valueOf(user.family_id).contains(newVal)
                        || user.notes.contains(newVal)
                        || user.regularity.contains(newVal)
                        || user.source.contains(newVal)
                        || String.valueOf(user.value).contains(newVal);
            });
        });

    }

}
