package test1;


import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.sql.*;
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
public class User extends RecursiveTreeObject<User>{
    public String user_name;
    public String password;

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
    
    public void Store() throws Exception
    {
        Connection conn = DB.get();
        PreparedStatement ps  = conn.prepareStatement("insert into users values (?,?)");
        ps.setString(1, user_name);
        ps.setString(2, password);
        ps.executeQuery();
        conn.close();
    }
    
    public static boolean isCorrect(String user_name, String password) throws Exception{
    Connection conn = DB.get();
    PreparedStatement ps  = conn.prepareStatement("select * from users where username = ? and password = ?");
    ps.setString(1,user_name);
    ps.setString(2,password);
    ResultSet rs = ps.executeQuery();
    //conn.close();
    //ps.close();
    return rs.next();
    }
    public static ObservableList<User> getAll() throws Exception {
        ObservableList<User> list = FXCollections.observableArrayList();
        Connection conn = DB.get();
        PreparedStatement ps = conn.prepareStatement("select * from users ");
        ResultSet rs = ps.executeQuery();
       // conn.close();
       // ps.close();
        while (rs.next()) {
            list.add(new User(rs.getString(1), rs.getString(2)));
            System.out.println(rs.getString(1));

        }
        return list;
    }
    public static void Update(User user) throws Exception{
         Connection conn = DB.get();
    PreparedStatement ps  = conn.prepareStatement("update users set password = ? where username = ?");
    ps.setString(2,user.user_name);
    ps.setString(1,user.password);
    ResultSet rs = ps.executeQuery();
        
    }
    
    
    
    
}
