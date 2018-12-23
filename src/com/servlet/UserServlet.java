package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Userdao;
import com.entity.User;
import com.util.DispatherServlet;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends DispatherServlet {
	private static final long serialVersionUID = 1L;
	private User user = new User();

	//登录
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String us = new String(request.getParameter("userName").getBytes("UTF-8"),"UTF-8");
        String ps = new String(request.getParameter("userPwd").getBytes("UTF-8"),"UTF-8");
        user = new Userdao().getlogn(us, ps);
		if(user.getUsername()!=null){
			session.setAttribute("user", user);
			session.setAttribute("login", true);
        	response.sendRedirect("Begin.jsp");
		}else{
			 out.println("用户名或密码有误，拒绝登入！");
             response.sendRedirect("login.jsp");
		}
        out.flush();
        out.close();
	}
	//注销
	public void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("Begin.jsp");
	}
	//注册
	public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		boolean flag=false;
		boolean isexit=false;
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String us = new String(request.getParameter("userName").getBytes("UTF-8"),"UTF-8");
        String ps = new String(request.getParameter("userPwd").getBytes("UTF-8"),"UTF-8");
        String phone = new String(request.getParameter("phone").getBytes("UTF-8"),"UTF-8");
        isexit=new Userdao().isexit(us);
        if(isexit){
        	out.print("false");  
        }else{
            User user = new User();
            user.setPassword(ps);
            user.setPhone(phone);
            user.setUsername(us);
    		flag= new Userdao().register(user);
    			if(flag){
    				out.print("true");
    			}else{
    				out.print("false");  
    			}
        }

        out.flush();
        out.close();
	}
	

}
