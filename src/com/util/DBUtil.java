package com.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection("jdbc:mysql://39.106.208.110:3306/estore?useUnicode=true&characterEncoding=gb2312","root","rootroot");
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
