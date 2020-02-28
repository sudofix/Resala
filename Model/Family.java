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
public class Family extends RecursiveTreeObject<Family> {

    public int area_code;
    public int rate;
    public int id;
    public String nick_name;
    public String husband_name;
    public int phone;
    public int mobile;
    public Date research_date;
    public String researcher;
    public String description;

    public Family(int area_code, int rate, int id, String nick_name, String husband_name, int phone, int mobile, Date research_date, String researcher, String description) {
        this.area_code = area_code;
        this.rate = rate;
        this.id = id;
        this.nick_name = nick_name;
        this.husband_name = husband_name;
        this.phone = phone;
        this.mobile = mobile;
        this.research_date = research_date;
        this.researcher = researcher;
        this.description = description;
    }

    public static boolean isExisted(int family_id) throws Exception {
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("select id from family where id = " + family_id);
        ResultSet rs = ps.executeQuery();
        conn.close();
        ps.close();
        return rs.next();
    }

    public void Store() throws Exception {
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("insert into family values (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, area_code);
        ps.setInt(2, rate);
        ps.setInt(3, id);
        ps.setString(4, nick_name);
        ps.setString(5, husband_name);
        ps.setInt(6, phone);
        ps.setInt(7, mobile);
        ps.setDate(8, research_date);
        ps.setString(9, researcher);
        ps.setString(10, description);

        ps.executeQuery();
        conn.close();
        ps.close();

    }

    public static ObservableList<Family> getAll() throws Exception {
        ObservableList<Family> list = FXCollections.observableArrayList();
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("select * from family");
        ResultSet rs = ps.executeQuery();
       
        while (rs.next()) {
            list.add(new Family(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDate(8), rs.getString(9), rs.getString(10)));
            System.out.println(rs.getInt(1));
        }
        return list;
    }

    public static void Update(Family i) throws Exception{
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("update family set area_code = ? , rate = ? , name = ? , husband_name = ? , phone = ? , mobile = ? , research_date = ? , researcher = ? , case_description = ? where id = ?");
        ps.setInt(1, i.area_code);
        ps.setInt(2, i.rate);
        ps.setString(3, i.nick_name);
        ps.setString(4, i.husband_name);
        ps.setInt(5, i.phone);
        ps.setInt(6, i.mobile);
        ps.setDate(7, i.research_date);
        ps.setString(8, i.researcher);
        ps.setString(9, i.description);
        ps.setInt(10, i.id);
        ps.executeQuery();
        conn.close();
        ps.close();

    }

}
