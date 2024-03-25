package com.blacksmith.banchan.login.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.login.dao.MemberDAO;
import com.blacksmith.banchan.util.Action;

public class IdCheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");

		MemberDAO mDAO = MemberDAO.getMemberDao();
		int result = mDAO.confirmID(userId);

		// 실제 로그인 처리 로직을 여기에 구현
		if (result > 0) {

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		} else {
			
			
			String answer = "available";
			response.getWriter().write(answer);
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

}
