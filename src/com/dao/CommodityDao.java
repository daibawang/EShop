package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Commodity;
import com.entity.MenuSecond;
import com.entity.User;
import com.sun.crypto.provider.RSACipher;
import com.util.DBUtil;


public class CommodityDao {
	DBUtil util = new DBUtil();
	//按照id查询商品信息
	public Commodity getCommodityById(int id) {
		// TODO Auto-generated method stub
		String sql = "select Id,Brand,Model,Price,Publishingdate,Salesamount,Storenumber,Remark,Url,md_id from estore.commodity WHERE Id = ?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            Commodity commodity = new Commodity();
            while(rs.next()){
            	commodity.setId(rs.getInt(1));
            	commodity.setBrand(rs.getString(2));
            	commodity.setModel(rs.getString(3));
            	commodity.setPrice(rs.getFloat(4));
            	commodity.setPublishingDate(rs.getString(5));
            	commodity.setSalesAmount(rs.getInt(6));
            	commodity.setStoreNumber(rs.getInt(7));
            	commodity.setRemark(rs.getString(8));
            	commodity.setUrl(rs.getString(9));
            	commodity.setMd_id(rs.getInt(10));
			}
            conn.close();
            return commodity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
		
	}
	
	//按照类型来查询所有商品--分页
    public List<Commodity> getCommodityByType(int md_id,int number,int start,int minPrice,int maxPrice) {
        String sql = "select Id,Brand,Model,Price,Publishingdate,Salesamount,Storenumber,Remark,Url,md_id from estore.commodity WHERE md_id = ? and Price BETWEEN ? AND ? limit ?,?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, md_id);
            pstmt.setInt(2, minPrice);
            pstmt.setInt(3, maxPrice);
            pstmt.setInt(4, start);
            pstmt.setInt(5, number);
            ResultSet rs = pstmt.executeQuery();
            List<Commodity> all = new ArrayList<Commodity>();
    		while (rs.next()) {
    			Commodity commodity = new Commodity();
    			commodity.setId(rs.getInt(1));
            	commodity.setBrand(rs.getString(2));
            	commodity.setModel(rs.getString(3));
            	commodity.setPrice(rs.getFloat(4));
            	commodity.setPublishingDate(rs.getString(5));
            	commodity.setSalesAmount(rs.getInt(6));
            	commodity.setStoreNumber(rs.getInt(7));
            	commodity.setRemark(rs.getString(8));
            	commodity.setUrl(rs.getString(9));
            	commodity.setMd_id(rs.getInt(10));
    			all.add(commodity);
    		}
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //按照类型查询总条数
    public int getAllCountByType(int md_id,int minPrice,int maxPrice) {
    	String sql = "select count(*) totalCount from estore.commodity WHERE md_id = ? and Price BETWEEN ? AND ?";
        Connection conn = util.getConnection();
        PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, md_id);
			pstmt.setInt(2, minPrice);
            pstmt.setInt(3, maxPrice);
	        ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        int count=rs.getInt("totalCount");
	        return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
