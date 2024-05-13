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
		
		int code = Integer.parseInt(request.getParameter("code"));

		
		AdminDAO pDao = AdminDAO.getAdminDao();
		pDao.deleteAdmin(code);
		
		response.sendRedirect("admin?command=admin_list");
		

	}

}
