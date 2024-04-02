package com.blacksmith.banchan.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.login.service.PasswordHashing;
import com.blacksmith.banchan.util.Action;
import com.blacksmith.banchan.util.TokenGenerator;

public class AdminLoginAction implements Action {
	private PasswordHashing passwordHashing = new PasswordHashing();
    private final AdminDAO adminDAO = new AdminDAO();
    private final TokenGenerator tokenGenerator = new TokenGenerator();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // passwordHashing.hashPassword(request.getParameter("adminPassword"));
        String adminId = request.getParameter("adminId");
        String adminPassword = request.getParameter("adminPassword");
        int result = adminDAO.adminCheck(adminId, adminPassword);

        // 실제 로그인 처리 로직을 여기에 구현
        if (result > 0) {
            // 토큰 생성 (여기서는 단순히 무작위 문자열로 토큰을 생성)
            String adminToken = tokenGenerator.generateJwtToken();

            // 클라이언트에게 토큰을 반환
            response.getWriter().write(adminToken);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 인증 실패 상태코드 반환
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
