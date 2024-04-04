package com.blacksmith.banchan.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.admin.dto.AdminVO;
import com.blacksmith.banchan.util.Action;

public class AdminDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("adminId"));

		
		AdminDAO pDao = AdminDAO.getAdminDao();
		pDao.deleteAdmin(id);
		
		response.sendRedirect("views/admin/admin-list.jsp");
		

	}

}
