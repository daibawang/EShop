package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.entity.MenuSecond;
import com.entity.Trade;
import com.entity.User;
import com.util.DBUtil;


public class TradeDao {
	DBUtil util = new DBUtil();
	private TradeItemDAO tradeItemDAO = new TradeItemDAO();
    public boolean insert(Trade trade) {
    	String sql = "INSERT INTO trade (userid, tradetime) VALUES " +
				"(?, ?)";
        	Connection conn = util.getConnection();
            try {
            	PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,trade.getUserId());
				pstmt.setString(2,trade.getTradeTime());
				if (pstmt.executeUpdate()>0)
	            {
	                conn.close();
	                return true;
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         return false;    
    }

    public int getindex() {
    	String sql = "select count(*) totalCount from estore.trade " ;
        	Connection conn = util.getConnection();
            try {
            	PreparedStatement pstmt = conn.prepareStatement(sql);
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
    
  
//	 根据 userId 获取和其关联的 Trade 的集合
	public List<Trade> getTradesWithUserId(int userId) {
		String sql = "SELECT tradeId, userId, tradeTime FROM trade " +
				"WHERE userId = ? ORDER BY tradeTime DESC";
		Connection conn = util.getConnection();
		try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            List<Trade> all = new ArrayList<Trade>();
    		while (rs.next()) {
    			Trade trade = new Trade();
    			trade.setTradeId(rs.getInt(1));
    			trade.setUserId(rs.getInt(2));
    			trade.setTradeTime(rs.getString(3));
    			trade.setTradeItems(tradeItemDAO.getTradeItemsWithTradeId(rs.getInt(1)));
    			trade.setTotalmoney(tradeItemDAO.getTotalMoneyByTradeId(rs.getInt(1)));
    			all.add(trade);
    		}
            conn.close();
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
}
