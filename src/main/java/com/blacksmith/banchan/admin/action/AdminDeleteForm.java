package com.blacksmith.banchan.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.admin.dto.AdminVO;
import com.blacksmith.banchan.util.Action;

public class AdminDeleteForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int code = Integer.parseInt(request.getParameter("code"));

		
		AdminDAO pDao = AdminDAO.getAdminDao();
		AdminVO pVo = pDao.getAdmin(code);
		
		request.setAttribute("admin", pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/admin-delete.jsp");
		dispatcher.forward(request, response);

	}

}
