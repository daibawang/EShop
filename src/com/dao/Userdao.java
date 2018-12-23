package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.User;
import com.util.DBUtil;

public class Userdao {
	DBUtil util = new DBUtil();
    public User getlogn(String us,String ps) {
        String sql = "select userid,username,password,phone from estore.user where username= ? and password= ?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,us);
            pstmt.setString(2,ps);
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            while(rs.next()){
            	user.setUserid(rs.getInt(1));
            	user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPhone(rs.getString(4));
			}
            conn.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean register(User user) {
        String sql = "insert into estore.user(username,password,phone) values(?,?,?)";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getPhone());
            if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public boolean isexit(String username) {
        String sql = "select count(userid) userCount from estore.user where username= ?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        int count=rs.getInt("userCount");
            if (count > 0) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    

}
