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
public class Appliance extends RecursiveTreeObject<Appliance>{
    public String type;
    public String status;
    public int family_id;

    public Appliance(String type, String status, int family_id) {
        this.type = type;
        this.status = status;
        this.family_id = family_id;
    }
    
    public void Store() throws Exception
    {
        Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("insert into appliance values (?,?,?)");
        ps.setString(1, type);
        ps.setString(2, status); 
        ps.setInt(3, family_id);   
        ps.executeQuery();
        ps.close();
        conn.close();
        
    }
    
    public static ObservableList<Appliance> getAll() throws Exception{
        ObservableList<Appliance> list = FXCollections.observableArrayList();
       Connection conn = DB.get();
       PreparedStatement ps = conn.prepareStatement("select * from appliance ");
       ResultSet rs = ps.executeQuery();
      
       while(rs.next())
       {
           list.add(new Appliance(  rs.getString(1), rs.getString(2), rs.getInt(3)  )     );
       }
       return list;
    }
    public static void Update(Appliance i)throws Exception{
         Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("update appliance set type = ? , status = ? where family_id = ? ");
        ps.setString(1, i.type);
        ps.setString(2, i.status); 
        ps.setInt(6, i.family_id);   
        ps.executeQuery();
        ps.close();
        conn.close();
    }
    
}
