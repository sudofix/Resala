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
public class Family_Member extends RecursiveTreeObject<Family_Member>{

    public String name;
    public int age;
    public boolean married;
    public String education;
    public String job;
    public int national_id;
    public int family_id;

    public Family_Member(String name,  int age, boolean married, String education, String job, int national_id,  int family_id) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.education = education;
        this.job = job;
        this.national_id = national_id;
        this.family_id = family_id;
        
    }

    public void Store() throws Exception {
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("insert into family_members values (?,?,?,?,?,?,?)");
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, married ? 1 : 0);
        ps.setString(4, education);
        ps.setString(5, job);
        ps.setInt(6, national_id);
        ps.setInt(7, family_id);
        
        ps.executeQuery();
        conn.close();
        ps.close();

    }
    /*
    public static ResultSet Retrieve(boolean name, boolean relation, boolean age, boolean marital_status, boolean marriage_needs, boolean education, boolean job, boolean national_id, boolean craft, boolean skills, int family_id, boolean medication) throws Exception {
        Connection conn = DB.get();
        String from = "";
        if(name)
            from.concat(", name ");
        if(relation)
            from.concat(", relation ");
        if(age)
            from.concat(", age ");
        if(name)
            from.concat(", name ");
        if(marital_status)
            from.concat(", marital_status ");
        if(marriage_needs)
            from.concat(", marriage_needs ");
        if(education)
            from.concat(", education ");
        if(job)
            from.concat(", job ");
        if(national_id)
            from.concat(", national_id ");
        if(craft)
            from.concat(", craft ");
        if(skills)
            from.concat(", skills ");
        if(medication)
            from.concat(", medication ");
        PreparedStatement ps = conn.prepareStatement("select " + from +  "from family_members where family_id = " + family_id);
        from.replaceFirst(", ", "");    
        ResultSet rs = ps.executeQuery();
        ps.close();
        conn.close();
        return rs;

    }
*/
    public static boolean isExisted(int national_id) throws Exception
    {
       Connection conn = DB.get();
       PreparedStatement ps = conn.prepareStatement("select national_id from family_members where national_id = " + national_id);
       ResultSet rs = ps.executeQuery();
       conn.close();
       ps.close();
       return rs.next();
    }
    public static ObservableList<Family_Member> getAll() throws Exception{
        ObservableList<Family_Member> list = FXCollections.observableArrayList();
       Connection conn = DB.get();
       PreparedStatement ps = conn.prepareStatement("select * from family_members ");
       ResultSet rs = ps.executeQuery();
       
       while(rs.next())
       {
           list.add(new Family_Member(  rs.getString(1), rs.getInt(2), ( rs.getInt(3) == 1 ? true : false) , rs.getString(4),rs.getString(5), rs.getInt(6) , rs.getInt(7)    )     );
       }
       return list;
        
    }
    public static void Update(Family_Member i) throws Exception{
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("update  family_members set name = ? , age = ? , married = ? , education = ? , job = ? where national_id = ?");
        ps.setString(1, i.name);
        ps.setInt(2, i.age);
        ps.setInt(3, i.married ? 1 : 0);
        ps.setString(4, i.education);
        ps.setString(5, i.job);
        ps.setInt(6, i.national_id);
        
        ps.executeQuery();
        conn.close();
        ps.close();
        
    }

}
