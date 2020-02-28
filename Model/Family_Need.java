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
public class Family_Need extends RecursiveTreeObject<Family_Need>{
    public String need;
    public boolean availability;
    public int family_id;

    public Family_Need(String need, boolean availability, int family_id) {
        this.need = need;
        this.availability = availability;
        this.family_id = family_id; 
    }
    public void Store() throws Exception
    {
        Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("insert into family_needs values (?,?,?)");
        ps.setString(1, need);
        ps.setBoolean(2, availability);
        ps.setInt(3, family_id);   
        ps.executeQuery();
        ps.close();
        conn.close();
    }
    
    public static ObservableList<Family_Need> getAll() throws Exception{
        ObservableList<Family_Need> list = FXCollections.observableArrayList();
       Connection conn = DB.get();
       PreparedStatement ps = conn.prepareStatement("select * from family_need ");
       ResultSet rs = ps.executeQuery();
       conn.close();
       ps.close();
       while(rs.next())
       {
           list.add(new Family_Need(  rs.getString(1), rs.getBoolean(2), rs.getInt(3) )     );
       }
       return list;
    }
    public static void Update(Family_Need i) throws Exception{
        Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("update family_needs set family_needs = ? , availability = ? where family_id = ?");
        ps.setString(1, i.need);
        ps.setInt(2, i.availability ? 1 : 0);
        ps.setInt(3, i.family_id);   
        ps.executeQuery();
        ps.close();
        conn.close();
        
    }
   
}
