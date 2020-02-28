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
public class Outer_Support extends RecursiveTreeObject<Outer_Support>{

    public String type;
    public int value;
    public String source;
    public String regularity;
    public String notes;
    public int family_id;

    public Outer_Support(String type, int value, String source, String regularity, String notes, int family_id) {
        this.type = type;
        this.value = value;
        this.source = source;
        this.regularity = regularity;
        this.notes = notes;
        this.family_id = family_id;
    }
    
    public void Store() throws Exception
    {
        Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("insert into outcome values (?,?,?,?,?,?)");
        ps.setString(1, type);
                ps.setInt(2, value);   

        ps.setString(3, source);
        ps.setString(4, regularity);
        ps.setString(5, notes);
        ps.setInt(6, family_id);   
        ps.executeQuery();
        ps.close();
        conn.close();
        
    }
    public static ObservableList<Outer_Support> getAll() throws Exception{
       ObservableList<Outer_Support> list = FXCollections.observableArrayList();
       Connection conn = DB.get();
       PreparedStatement ps = conn.prepareStatement("select * from outer_support ");
       ResultSet rs = ps.executeQuery();
       conn.close();
       ps.close();
       while(rs.next())
       {
           list.add(new Outer_Support(  rs.getString(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getInt(6)  )     );
       }
       return list;
    }
    public static void Update(Outer_Support i) throws Exception{
        Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("update outer_support set type = ? , value = ? , source = ? , regularity = ? , notes = ? where family_id = ? ");
        ps.setString(1, i.type);
                ps.setInt(2, i.value);   

        ps.setString(3, i.source);
        ps.setString(4, i.regularity);
        ps.setString(5, i.notes);
        ps.setInt(6, i.family_id);   
        ps.executeQuery();
        ps.close();
        conn.close();
        
    }
    

}
