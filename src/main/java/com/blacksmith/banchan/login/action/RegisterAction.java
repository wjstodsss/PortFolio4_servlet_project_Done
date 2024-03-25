package com.blacksmith.banchan.login.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blacksmith.banchan.login.dao.MemberDAO;
import com.blacksmith.banchan.login.dto.MemberVO;
import com.blacksmith.banchan.util.Action;

public class RegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String admin = request.getParameter("admin");

		MemberVO mVo = new MemberVO();
		System.out.println("ffffffff");
		mVo.setUserName(userName);
		mVo.setUserId(userId);
		mVo.setUserPassword(userPassword);
		mVo.setUserEmail(userEmail);
		mVo.setUserPhone(userPhone);
		mVo.setAdmin(Integer.parseInt(admin));

		MemberDAO mDao = MemberDAO.getMemberDao();
		int result = mDao.insertMember(mVo);

		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("userid", mVo.getUserId());
			request.setAttribute("message", "회원가입에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
		dispatcher.forward(request, response);
	}

}
