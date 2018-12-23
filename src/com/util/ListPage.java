package com.util;

import java.util.ArrayList;
import java.util.List;

import com.entity.Commodity;

//分页查询的工具类，在前台分页显示时使用
public class ListPage {
	 //当前页码
    private int pageIndex;
    //每页显示的记录条数
    private int pageSize;
    //总页数
    private int pageCount;
    //当前页的数据
    private List<Commodity> CommodityList = new ArrayList<Commodity>();
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return the rebList
	 */
	public List<Commodity> getRebList() {
		return CommodityList;
	}
	/**
	 * @param rebList the rebList to set
	 */
	public void setRebList(List<Commodity> rebList) {
		CommodityList = rebList;
	}
    
    
    
}
