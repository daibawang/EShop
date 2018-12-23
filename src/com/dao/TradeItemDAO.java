package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.entity.Trade;
import com.entity.TradeItem;
import com.util.DBUtil;

public class TradeItemDAO {
	DBUtil util = new DBUtil();
	private CommodityDao commodityDao = new CommodityDao();
	//生成新的记录
	public void batchSave(List<TradeItem> items) {
		String sql = "INSERT INTO tradeitem(computerid, quantity, tradeid) " +
				"VALUES(?,?,?)";
		Connection conn = util.getConnection();
			try {
				for(int i = 0; i < items.size(); i++){
					PreparedStatement pstmt;
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,items.get(i).getCommodityId());
					pstmt.setInt(2,items.get(i).getQuantity());
					pstmt.setInt(3,items.get(i).getTradeId());
					pstmt.executeUpdate();
					System.out.println(items.get(i).getTradeId()+"TradeId");
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	//根据tradeid查询TradeItem
	public List<TradeItem> getTradeItemsWithTradeId(int tradeId) {
		String sql = "SELECT itemid , computerid, " +
				"quantity, tradeid FROM tradeitem WHERE tradeid = ?";
		Connection conn = util.getConnection();
		try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, tradeId);
            ResultSet rs = pstmt.executeQuery();
            List<TradeItem> all = new ArrayList<TradeItem>();
    		while (rs.next()) {
    			TradeItem trade = new TradeItem();
    			trade.setTradeItemId(rs.getInt(1));
    			trade.setCommodityId(rs.getInt(2));
    			trade.setQuantity(rs.getInt(3));
    			trade.setTradeId(rs.getInt(4));
    			trade.setCommodity(commodityDao.getCommodityById(rs.getInt(2)));
    			all.add(trade);
    		}
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
      
	}
	
	//根据tradeid查询订单总金额
		public float getTotalMoneyByTradeId(int tradeId) {
			String sql = "SELECT itemid , computerid, " +
					"quantity, tradeid FROM tradeitem WHERE tradeid = ?";
			Connection conn = util.getConnection();
			try {
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, tradeId);
	            ResultSet rs = pstmt.executeQuery();
	            List<TradeItem> all = new ArrayList<TradeItem>();
	            float onlyprice = 0;
	            int quantity = 0;
	            float total = 0;
	    		while (rs.next()) {
	    			quantity = rs.getInt(3);
	    			onlyprice = commodityDao.getCommodityById(rs.getInt(2)).getPrice();
	    			total = total+quantity*onlyprice;
	    		}
	            conn.close();
	            return total;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	      
		}
}
