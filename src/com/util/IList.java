package com.util;

import java.util.List;

import com.dao.CommodityDao;
import com.entity.Commodity;

import net.sf.json.JSONArray;

public class IList {
	public ListPage getListPage(int md_id,int pageSize,int pageIndex,int minPrice,int maxPrice){
		ListPage listpage = new ListPage();
		
		CommodityDao rDao = new CommodityDao();
		int start=(pageIndex - 1) * pageSize;
		List<Commodity> list=rDao.getCommodityByType(md_id, pageSize,start,minPrice,maxPrice);
		int count=rDao.getAllCountByType(md_id,minPrice,maxPrice); //计算需要分的页数
		int pageCount = 0;
	      if(count%pageSize == 0){
	          pageCount = count/pageSize;
	      }else{
	          pageCount = count/pageSize + 1;
	      }
	      listpage.setRebList(list);
	      listpage.setPageCount(pageCount);
	      listpage.setPageIndex(pageIndex);
	      listpage.setPageSize(pageSize);
//	      	JSONArray json = null;
//			json=new JSONArray().fromObject(list);
	      
	   return listpage;
  }

  //获得列表
  public List<Commodity> getNewsList(int md_id,int pageSize,int pageIndex,int minPrice,int maxPrice){
	  CommodityDao rDao = new CommodityDao();
      List<Commodity> ComdList = rDao.getCommodityByType(md_id,pageSize, pageIndex,minPrice,maxPrice);
      return ComdList;
  }
  
  //获得记录总数
  public int getNewsCount(int md_id,int minPrice,int maxPrice){
	  CommodityDao rDao = new CommodityDao();
      int count = rDao.getAllCountByType(md_id,minPrice,maxPrice);
      return count;
  }

}
