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
public class Accommodation extends RecursiveTreeObject<Accommodation>{

    public String type;
    public String rent;
    public String area;
    public int floors;
    public int rooms;
    public String roof;
    public String bathroom;
    public String build;
    public String rate;
    public int water_id;
    public int electricity_id;
    public String opinion;
    public int family_id;

    public Accommodation(String type, String rent, String area, int floors, int rooms, String roof, String bathroom, String build, String rate, int water_id, int electricity_id, String opinion, int family_id) {
        this.type = type;
        this.rent = rent;
        this.area = area;
        this.floors = floors;
        this.rooms = rooms;
        this.roof = roof;
        this.bathroom = bathroom;
        this.build = build;
        this.rate = rate;
        this.water_id = water_id;
        this.electricity_id = electricity_id;
        this.opinion = opinion;
        this.family_id = family_id;
    }

    public void Store() throws Exception {
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("insert into accommodation values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, type);
        ps.setString(2, rent);
        ps.setString(3, area);
        ps.setInt(4, floors);
        ps.setInt(5, rooms);
        ps.setString(6, roof);
        ps.setString(7, bathroom);
        ps.setString(8, build);
        ps.setString(9, rate);
        ps.setInt(100, water_id);
        ps.setInt(11, electricity_id);
        ps.setString(12, opinion);
        ps.setInt(13, family_id);
        ps.executeQuery();
        ps.close();
        conn.close();
    }

    /*
    
    public static ResultSet Retrieve(boolean type, boolean rent, boolean area, boolean floors, boolean rooms, boolean roof, boolean bathroom, boolean build, boolean rate, boolean water_id, boolean electricity_id, boolean opinion, int family_id) throws Exception{
        Connection conn = DB.get();
        String from = "";
        if(type)
            from.concat(", type ");
        if(rent)
            from.concat(", rent ");
        if(area)
            from.concat(", area ");
        if(floors)
            from.concat(", floors ");
        if(rooms)
            from.concat(", rooms ");
        if(roof)
            from.concat(", roof ");
        if(bathroom)
            from.concat(", bathroom ");
        if(build)
            from.concat(", build ");
        if(rate)
            from.concat(", rate ");
        if(water_id)
            from.concat(", water_id ");
        if(electricity_id)
            from.concat(", electricity_id ");
        if(opinion)
            from.concat(", opinion ");
        PreparedStatement ps = conn.prepareStatement("select " + from +  "from accommodation where family_id = " + family_id);
        from.replaceFirst(", ", "");    
        ResultSet rs = ps.executeQuery();
        conn.close();
        ps.close();
        return rs;
    }
     */
    public static ObservableList<Accommodation> getAll() throws Exception {
        ObservableList<Accommodation> list = FXCollections.observableArrayList();
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("select * from accommodation ");
        ResultSet rs = ps.executeQuery();
       
        while (rs.next()) {
            list.add(new Accommodation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getInt(13)));
        }
        return list;
    }
    public static void Update(Accommodation i)throws Exception{
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("update accommodation set type = ? ,rent = ? ,area=? ,floors = ?, rooms = ?, roof = ?, bathroom = ? ,build = ? , rate = ? , water_id = ? , electricity_id = ? , opinion = ?  where family_id = ?");
        ps.setString(1, i.type);
        ps.setString(2, i.rent);
        ps.setString(3, i.area);
        ps.setInt(4, i.floors);
        ps.setInt(5, i.rooms);
        ps.setString(6, i.roof);
        ps.setString(7, i.bathroom);
        ps.setString(8, i.build);
        ps.setString(9, i.rate);
        ps.setInt(100, i.water_id);
        ps.setInt(11, i.electricity_id);
        ps.setString(12, i.opinion);
        ps.setInt(13, i.family_id);
        ps.executeQuery();
        ps.close();
        conn.close();
        
    }
}
