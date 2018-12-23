package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MenuDao;
import com.dao.Userdao;
import com.entity.MenuFirst;
import com.entity.MenuSecond;
import com.util.DispatherServlet;

import net.sf.json.JSONArray;
import net.sf.json.util.NewBeanInstanceStrategy;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends DispatherServlet {
	private static final long serialVersionUID = 1L;
    private MenuSecond menuSecond = new MenuSecond();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void MenuSecondByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        Integer menuid = new Integer(request.getParameter("menuid"));
        List<MenuSecond> list=new MenuDao().getMenuByType(menuid);
        if (list != null) {
            JSONArray array = JSONArray.fromObject(list);
            out.print(array);
        } else {
            out.print(false);
        }
        out.flush();
        out.close();
	}
	
	public void MenuFirst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        List<MenuFirst> list=new MenuDao().getMenu();
        if (list != null) {
        	String page = "homepage";
        	request.getSession().setAttribute("thispage",page );
        	request.getSession().setAttribute("menutype", list);
        	request.getRequestDispatcher("index.jsp").forward(request, response);
//            JSONArray array = JSONArray.fromObject(list);
//            out.print(array);
           
        } else {
            out.print(false);
        }
        out.flush();
        out.close();
	}
	

}
