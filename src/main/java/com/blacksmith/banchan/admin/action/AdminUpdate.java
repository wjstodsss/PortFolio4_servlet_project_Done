package com.blacksmith.banchan.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.admin.dto.AdminVO;
import com.blacksmith.banchan.login.service.PasswordHashing;
import com.blacksmith.banchan.util.Action;

public class AdminUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordHashing passwordHashing = new PasswordHashing(); 
		String adminName = request.getParameter("adminName");
		request.setCharacterEncoding("UTF-8");
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		String adminId = request.getParameter("adminId");
		
		String adminPassword = request.getParameter("adminPassword");
		
		if(request.getParameter("newPassword") != null) {
			adminPassword = passwordHashing.hashPassword(request.getParameter("newPassword"));
		} 
		
		String adminEmail = request.getParameter("adminEmail");
		String adminPhone = request.getParameter("adminPhone");
		String admin = request.getParameter("admin");

		AdminVO mVo = new AdminVO();
		mVo.setCode(code);
		mVo.setAdminName(adminName);
		mVo.setAdminId(adminId);
		mVo.setAdminPassword(adminPassword);
		mVo.setAdminEmail(adminEmail);
		mVo.setAdminPhone(adminPhone);
		mVo.setAdmin(Integer.parseInt(admin));

		AdminDAO mDao = AdminDAO.getAdminDao();
		
		int result = mDao.updateAdmin(mVo);
		
		response.sendRedirect("admin?command=admin_list");

	}

}
