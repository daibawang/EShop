package com.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;

public abstract class DispatherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=UTF8");
       
       String methodName = request.getParameter("method");
		try {
			// 利用反射获取方法
			Method method =  this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			// 执行相应的方法
//			method.setAccessible(true);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("方法不存在,請傳入正確的method參數");
		}
		
	}
}
