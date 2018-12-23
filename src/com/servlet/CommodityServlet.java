package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommodityDao;
import com.dao.MenuDao;
import com.dao.TradeDao;
import com.dao.TradeItemDAO;
import com.dao.Userdao;
import com.entity.Commodity;
import com.entity.MenuSecond;
import com.entity.ShoppingCart;
import com.entity.ShoppingCartItem;
import com.google.gson.Gson;
import com.util.DispatherServlet;
import com.util.EStoreWebUtils;
import com.util.IList;
import com.util.ListPage;
import com.entity.Trade;
import com.entity.TradeItem;
import com.entity.User;

import net.sf.json.JSONArray;
import sun.launcher.resources.launcher_zh_TW;

/**
 * Servlet implementation class CommodityServlet
 */
@WebServlet("/CommodityServlet")
public class CommodityServlet extends DispatherServlet {
	private static final long serialVersionUID = 1L;
	private List<Commodity> list = new ArrayList<Commodity>();
	private Commodity commodity=new Commodity();
	private CommodityDao commodityDao=new CommodityDao();
	private User user = new User();
	private TradeDao tradeDao = new TradeDao();
	private TradeItemDAO tradeItemDAO = new TradeItemDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void GetCdityById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        int cid=0;
		try {
			cid = new Integer(request.getParameter("menuid"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		if (cid > 0) {
			commodity = new CommodityDao().getCommodityById(cid);
		}
		//不存在
		if (commodity == null) {
//			response.sendRedirect(request.getContextPath()+"/error-1.jsp");
			return ;
		}
		JSONArray json = null;
    	json=new JSONArray().fromObject(commodity);
    	System.out.print(json);
		request.setAttribute("commodity", commodity);
		request.getRequestDispatcher("commodity.jsp").forward(request, response);
        out.flush();
        out.close();
	}

    
	public void CommodityByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

        IList Redlist = new IList();
        // 设定默认的每页显示条数
        int pageSize = 6;
        // 设定默认的页码数
        int pageIndex = 1;
        
        Integer menuid = 1;
        Integer minPrice=0;
        Integer maxPrice=500000;
        
		try {
			menuid = new Integer(request.getParameter("menuid"));
			minPrice = new Integer(request.getParameter("minPrice"));
			maxPrice = new Integer(request.getParameter("maxPrice"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
        String currentIndex = request.getParameter("pageIndex");
        
        if(currentIndex != null){
            pageIndex = Integer.parseInt(currentIndex);
            
        }
      //获得分页的列表
        ListPage listPage = Redlist.getListPage(menuid, pageSize, pageIndex,minPrice,maxPrice);
        
        if (listPage != null){
        	JSONArray json = null;
        	json=new JSONArray().fromObject(listPage);
        	out.print(json);
        }else{
        	out.print("0");
        }
        out.flush();
        out.close();
	}
	//添加到购物车
	public void addToCartIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 获取商品的 id
		int id = -1;
		boolean flag = false;
		try {
			id = Integer.parseInt(request.getParameter("menuid"));
		} catch (Exception e) {}
		
		if(id > 0){
			//2. 获取购物车对象
			ShoppingCart sc = EStoreWebUtils.getShoppingCart(request);
			
			//3. 把商品放到购物车中
			flag = addToCart(id, sc);
		}
		if(flag){
			//4. 直接调用 getCommidy() 方法. 
			getCommidies(request, response);
			return;
		}
	}
	//添加到购物车（商品详情页添加）
	public void addToCartInside(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. 获取商品的 id
		int id = -1;
		boolean flag = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {}
		
		if(id > 0){
			//2. 获取购物车对象
			ShoppingCart sc = EStoreWebUtils.getShoppingCart(request);
			
			//3.把商品放到购物车中
			flag = addToCart(id, sc);
		}
		if(flag){
			//4. 直接调用 getCommidy() 方法. 
			getCommidy(request, response);
			return;
		}
		
	}
	public boolean addToCart(int id, ShoppingCart sc) {
		// TODO Auto-generated method stub
		Commodity commodity = commodityDao.getCommodityById(id);
		
		if (commodity != null) {
			sc.addCommodity(commodity);
			return true;
		}
		return false;
		
		
	}
	public void getCommidies(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String idStr = request.getParameter("menuid");
		int id = -1;
		Commodity commodity = null;
		
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}
		if (id > 0) {
			commodity = commodityDao.getCommodityById(id);
		}
		
		request.setAttribute("commodity", commodity);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	public void getCommidy(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String idStr = request.getParameter("id");
		int id = -1;
		Commodity commodity = null;
		
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}
		if (id > 0) {
			commodity = commodityDao.getCommodityById(id);
		}
		
		request.setAttribute("commodity", commodity);
		request.getRequestDispatcher("commodity.jsp").forward(request, response);
	}
	
	public void updateItemQuantity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//4. 在 updateItemQuantity 方法中, 获取 quanity, id, 再获取购物车对象, 调用 service 的方法做修改
	String idStr = request.getParameter("id");
	String quantityStr = request.getParameter("quantity");
	
	ShoppingCart sc = EStoreWebUtils.getShoppingCart(request);
	
	int id = -1;
	int quantity = -1;
	
	try {
		id = Integer.parseInt(idStr);
		quantity = Integer.parseInt(quantityStr);
	} catch (Exception e) {}
	
	if(id > 0 && quantity > 0)
		sc.updateItemQuantity(id, quantity);
	
	//5. 传回 JSON 数据: 
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("computerNumber", sc.getComputerNumber());
	result.put("totalMoney", sc.getTotalMoney());
	
	Gson gson = new Gson();
	String jsonStr = gson.toJson(result);
	response.setContentType("text/javascript");
	response.getWriter().print(jsonStr);
}
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String idStr = request.getParameter("id");
	
	int id = -1;
	boolean flag = false;
	try {
		id = Integer.parseInt(idStr);
	} catch (Exception e) {}
	
	ShoppingCart sc = EStoreWebUtils.getShoppingCart(request);
		sc.removeItem(id);
	
	if(sc.isEmpty()){
		request.getRequestDispatcher("emptycart.jsp").forward(request, response);
		return;
	}
	
	request.getRequestDispatcher("cart.jsp").forward(request, response);
	
}
	public void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ShoppingCart sCart = EStoreWebUtils.getShoppingCart(request);
			sCart.clear();
	request.getRequestDispatcher("emptycart.jsp").forward(request, response);
}
	public void cash(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 简单验证: 验证表单域的值是否符合基本的规范: 是否为空, 是否可以转为 int 类型, 是否是一个 email. 不需要进行查询
		//数据库或调用任何的业务方法.
		String username = request.getParameter("username");
		String accountId = request.getParameter("accountId");
		HttpSession session=request.getSession();
		Userdao userdao = new Userdao();
		boolean flg = userdao.isexit(username);
		if(flg){
			
			//3. 向 trade 数据表插入一条记录
			Trade trade = new Trade();
			long time = System.currentTimeMillis(); 
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String tradeTime=simpleDateFormat.format(time);
			System.out.println(tradeTime);
			trade.setTradeTime(tradeTime);
			User user = new User();
			user=(User)session.getAttribute("user"); //获取会话中的信息
			int userid = 0;
			if(user!=null){
				trade.setUserId(user.getUserid());
			}
			trade.setTradeId(tradeDao.getindex()+1);
			tradeDao.insert(trade);
			
			//4. 向 tradeitem 数据表插入 n 条记录
			List<TradeItem> items = new ArrayList<>();
			ShoppingCart shoppingCart = EStoreWebUtils.getShoppingCart(request);
			for(ShoppingCartItem sci: shoppingCart.getItems()){
				TradeItem tradeItem = new TradeItem();
				tradeItem.setCommodityId(sci.getCommodity().getId());
				tradeItem.setQuantity(sci.getQuantity());
				tradeItem.setTradeId(trade.getTradeId());
				items.add(tradeItem);
			}
			tradeItemDAO.batchSave(items);
			//5. 清空购物车
			shoppingCart.clear();
			response.sendRedirect("success.jsp");
		}
	}
	
	
	
}
