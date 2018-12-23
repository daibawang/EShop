package com.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Trade {

	//Trade 对象对应的 id
	private Integer tradeId;
	
	//交易的时间
	private String tradeTime;

	//Trade 关联的多个 TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();
	private List<TradeItem> tradeItems = new ArrayList<TradeItem>();
	private float totalmoney;
	
	/**
	 * @return the totalmoney
	 */
	public float getTotalmoney() {
		return totalmoney;
	}

	/**
	 * @param totalmoney the totalmoney to set
	 */
	public void setTotalmoney(float totalmoney) {
		this.totalmoney = totalmoney;
	}

	/**
	 * @return the tradeItems
	 */
	public List<TradeItem> getTradeItems() {
		return tradeItems;
	}

	/**
	 * @param tradeItems the tradeItems to set
	 */
	public void setTradeItems(List<TradeItem> tradeItems) {
		this.tradeItems = tradeItems;
	}

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}
	
	public Set<TradeItem> getItems() {
		return items;
	}

	//和 Trade 关联的 User 的 userId
	private Integer userId;
	
	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	/**
	 * @return the tradeTime
	 */
	public String getTradeTime() {
		return tradeTime;
	}

	/**
	 * @param tradeTime the tradeTime to set
	 */
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime
				+ ", userId=" + userId + "]";
	}
}

