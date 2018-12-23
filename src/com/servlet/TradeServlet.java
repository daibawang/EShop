package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MenuDao;
import com.dao.TradeDao;
import com.entity.Commodity;
import com.entity.MenuSecond;
import com.entity.Trade;
import com.entity.TradeItem;
import com.util.DispatherServlet;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TradeServlet
 */
@WebServlet("/TradeServlet")
public class TradeServlet extends DispatherServlet {
	private static final long serialVersionUID = 1L;
	private List<Trade> list = new ArrayList<Trade>();
	
    public TradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void TradeByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        Integer userid = new Integer(request.getParameter("userid"));
        list=new TradeDao().getTradesWithUserId(userid);
        System.out.println(list);
        if (list != null) {
        	request.getSession().setAttribute("tradescount", list.size());
        	request.getSession().setAttribute("trades", list);
        	request.getRequestDispatcher("trades.jsp").forward(request, response);
//            JSONArray array = JSONArray.fromObject(list);
//            out.print(array);
        } else {
            out.print(false);
        }
        out.flush();
        out.close();
	}

	

}
