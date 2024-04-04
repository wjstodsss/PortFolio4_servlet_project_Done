package com.blacksmith.banchan.admin.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.admin.dto.AdminVO;
import com.blacksmith.banchan.login.service.PasswordHashing;
import com.blacksmith.banchan.util.Action;

public class AdminListRegister implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordHashing passwordHashing = new PasswordHashing(); 
		
		
		String adminName = request.getParameter("adminName");
		String adminId = request.getParameter("adminId");
		String adminPassword = passwordHashing.hashPassword(request.getParameter("adminPassword"));
		String adminEmail = request.getParameter("adminEmail");
		String adminPhone = request.getParameter("adminPhone");
		String admin = request.getParameter("admin");

		AdminVO mVo = new AdminVO();
		mVo.setAdminName(adminName);
		mVo.setAdminId(adminId);
		mVo.setAdminPassword(adminPassword);
		mVo.setAdminEmail(adminEmail);
		mVo.setAdminPhone(adminPhone);
		mVo.setAdmin(Integer.parseInt(admin));

		AdminDAO mDao = AdminDAO.getAdminDao();
		int result = mDao.insertAdmin(mVo);
		
		response.sendRedirect("banchan?command=admin_list");
	}
}
