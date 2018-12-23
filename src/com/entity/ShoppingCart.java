package com.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	private Map<Integer, ShoppingCartItem> commodities = new HashMap<>();
	
	/**
	 * 修改指定购物项的数量
	 */
	public void updateItemQuantity(Integer id, int quantity){
		ShoppingCartItem sci =commodities.get(id);
		if(sci != null){
			sci.setQuantity(quantity);
		}
	}
	/**
	 * 移除指定的购物项
	 * @param id
	 */
	public void removeItem(Integer id){
		commodities.remove(id);
	}
	/**
	 * 清空购物车
	 */
	public void clear(){
		commodities.clear();
	}
	/**
	 * 返回购物车是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return commodities.isEmpty();
	}
	
	/**
	 * 获取购物车中所有的商品的总的钱数
	 * @return
	 */
	public float getTotalMoney(){
		float total = 0;
		
		for(ShoppingCartItem sci: getItems()){
			total += sci.getItemMoney();
		}
		
		return total;
	}
	/**
	 * 获取购物车中的所有的 ShoppingCartItem 组成的集合
	 * @return
	 */
	public Collection<ShoppingCartItem> getItems(){
		return commodities.values();
	}
	

	/**
	 * 返回购物车中商品的总数量
	 * @return
	 */
	public int getComputerNumber(){
		int total = 0;
		
		for(ShoppingCartItem sci: commodities.values()){
			total += sci.getQuantity();
		}
		
		return total;
	}
	
	public Map<Integer, ShoppingCartItem> getComputers() {
		return commodities;
	}
	
	/**
	 * 检验购物车中是否有 id 指定的商品		
	 * @param id
	 * @return
	 */
	public boolean hasComputer(Integer id){
		return commodities.containsKey(id);
	}		
			
	/**
	 * 向购物车中添加一件商品		
	 * @param computer
	 */
	public void addCommodity(Commodity cdity){
		//1. 检查购物车中有没有该商品, 若有, 则使其数量 +1, 若没有, 
		//新创建其对应的 ShoppingCartItem, 并把其加入到 commodities 中
		ShoppingCartItem sci = commodities.get(cdity.getId());
		
		if(sci == null){
			sci = new ShoppingCartItem(cdity);
			commodities.put(cdity.getId(), sci);
		}else{
			sci.increment();
		}
	}
	
}
