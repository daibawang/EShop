package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.MenuFirst;
import com.entity.MenuSecond;
import com.util.DBUtil;

public class MenuDao {
	DBUtil util = new DBUtil();
    public List<MenuSecond> getMenuByType(int m_id) {
        String sql = "select md_id,md_name,m_id,m_info from estore.menudetail where m_id= ?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, m_id);
            ResultSet rs = pstmt.executeQuery();
            List<MenuSecond> all = new ArrayList<MenuSecond>();
    		while (rs.next()) {
    			MenuSecond menu = new MenuSecond();
    			menu.setMd_id(rs.getInt(1));
            	menu.setMd_name(rs.getString(2));
            	menu.setM_id(rs.getInt(3));
            	menu.setM_info(rs.getString(4));
    			all.add(menu);
    		}
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<MenuFirst> getMenu() {
        String sql = "select m_id,m_name from estore.menutype";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<MenuFirst> all = new ArrayList<MenuFirst>();
    		while (rs.next()) {
    			MenuFirst menu = new MenuFirst();
    			menu.setM_id(rs.getInt(1));
            	menu.setM_name(rs.getString(2));
    			all.add(menu);
    		}
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
