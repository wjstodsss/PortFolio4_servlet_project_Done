package com.blacksmith.banchan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.util.Action;




@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String command = request.getParameter("command");
		System.out.println("adminServlet에서 요청을 받음을 확인 : " + command);
		AdminActionFactory af = AdminActionFactory.getInstance();
				
		Action action = af.getAction(command);

		if(action != null){
		  action.execute(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}