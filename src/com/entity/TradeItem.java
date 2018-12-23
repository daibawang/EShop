package com.entity;


public class TradeItem {

	private Integer tradeItemId;
	
	//和 TradeItem 关联的 Commodity
	private Commodity commodity;
	
	private int quantity;
	
	//和 TradeItem 关联的 Commodity 的 commodityId
	private Integer commodityId;

	private Integer tradeId;

	

	/**
	 * @return the tradeItemId
	 */
	public Integer getTradeItemId() {
		return tradeItemId;
	}



	/**
	 * @param tradeItemId the tradeItemId to set
	 */
	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}



	/**
	 * @return the commodity
	 */
	public Commodity getCommodity() {
		return commodity;
	}



	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the commodityId
	 */
	public Integer getCommodityId() {
		return commodityId;
	}



	/**
	 * @param commodityId the commodityId to set
	 */
	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}



	/**
	 * @return the tradeId
	 */
	public Integer getTradeId() {
		return tradeId;
	}



	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}



	public TradeItem() {
		// TODO Auto-generated constructor stub
	}



	public TradeItem(Integer tradeItemId, Commodity commodity, int quantity, Integer commodityId, Integer tradeId) {
		super();
		this.tradeItemId = tradeItemId;
		this.commodity = commodity;
		this.quantity = quantity;
		this.commodityId = commodityId;
		this.tradeId = tradeId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TradeItem [tradeItemId=" + tradeItemId + ", commodity=" + commodity + ", quantity=" + quantity
				+ ", commodityId=" + commodityId + ", tradeId=" + tradeId + "]";
	}


}
