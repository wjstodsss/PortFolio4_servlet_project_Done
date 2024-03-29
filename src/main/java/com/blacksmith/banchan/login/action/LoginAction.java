package com.blacksmith.banchan.login.action;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.login.dao.MemberDAO;
import com.blacksmith.banchan.login.service.PasswordHashing;
import com.blacksmith.banchan.util.Action;

public class LoginAction implements Action {
	
	
	private PasswordHashing passwordHashing = new PasswordHashing();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		String userPassword = passwordHashing.hashPassword(request.getParameter("userPassword"));
		MemberDAO mDAO = MemberDAO.getMemberDao();
		int result = mDAO.memberCheck(userId, userPassword);

		// 실제 로그인 처리 로직을 여기에 구현
		if (result > 0) {
			// 토큰 생성 (여기서는 단순히 무작위 문자열로 토큰을 생성)
			String token = generateToken();
			
			// 클라이언트에게 토큰을 반환
			response.getWriter().write(token);
			response.setStatus(HttpServletResponse.SC_OK);
			System.out.println(token);
			String url = "/views/index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} else {
			// 인증 실패 상태코드 반환
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	public static String generateToken() {
		// 무작위 바이트 배열 생성
		byte[] randomBytes = new byte[32];
		new SecureRandom().nextBytes(randomBytes);

		// 바이트 배열을 Base64 인코딩하여 문자열로 변환하여 반환
		return Base64.getEncoder().encodeToString(randomBytes);
	}

}
