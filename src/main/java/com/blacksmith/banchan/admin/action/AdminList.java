package com.blacksmith.banchan.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.admin.dto.AdminVO;
import com.blacksmith.banchan.util.Action;

public class AdminList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAO bDao = AdminDAO.getAdminDao();
	    List<AdminVO> adminList = bDao.getAllAdmin();
	    request.setAttribute("adminList", adminList);
		
		String url = "/views/admin/adminList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
