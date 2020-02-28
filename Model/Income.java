package test1;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mohamed
 */
public class Income extends RecursiveTreeObject<Income>{

    public int value;
    public String detail;
    public int family_id;

    public Income(int value, String detail, int family_id) {
        this.value = value;
        this.detail = detail;
        this.family_id = family_id;
    }

    public void Store() throws Exception {
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("insert into income values (?,?,?)");
        ps.setInt(1, value);

        ps.setString(2, detail);
        ps.setInt(3, family_id);
        ps.executeQuery();
        ps.close();
        conn.close();
    }

    public static ObservableList<Income> getAll() throws Exception {
        ObservableList<Income> list = FXCollections.observableArrayList();
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("select * from income ");
        ResultSet rs = ps.executeQuery();
        conn.close();
        ps.close();
        while (rs.next()) {
            list.add(new Income(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        return list;
    }
    public static void Update(Income i) throws Exception{
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("update  income set value = ? , details = ? where family_id = ?");
        ps.setInt(1, i.value);

        ps.setString(2, i.detail);
        ps.setInt(3, i.family_id);
        ps.executeQuery();
        ps.close();
        conn.close();
        
    }

}
