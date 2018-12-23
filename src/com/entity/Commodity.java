package com.entity;

import java.sql.Date;

public class Commodity {
	private Integer id;
	
	private String brand;
	
	private String model;
	
	private float price;
	
	private String publishingDate;

	private int salesAmount;
	
	private int storeNumber;
	
	private String remark;
	
	private String url;
	
	private Integer md_id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the publishingDate
	 */


	/**
	 * @return the salesAmount
	 */
	public int getSalesAmount() {
		return salesAmount;
	}

	/**
	 * @param salesAmount the salesAmount to set
	 */
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	/**
	 * @return the storeNumber
	 */
	public int getStoreNumber() {
		return storeNumber;
	}

	/**
	 * @param storeNumber the storeNumber to set
	 */
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the md_id
	 */
	public Integer getMd_id() {
		return md_id;
	}

	/**
	 * @param md_id the md_id to set
	 */
	public void setMd_id(Integer md_id) {
		this.md_id = md_id;
	}

	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commodity(Integer id, String brand, String model, float price, String publishingDate, int salesAmount,
			int storeNumber, String remark, String url, Integer md_id) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.publishingDate = publishingDate;
		this.salesAmount = salesAmount;
		this.storeNumber = storeNumber;
		this.remark = remark;
		this.url = url;
		this.md_id = md_id;
	}

	/**
	 * @return the publishingDate
	 */
	public String getPublishingDate() {
		return publishingDate;
	}

	/**
	 * @param publishingDate the publishingDate to set
	 */
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}
	

}
