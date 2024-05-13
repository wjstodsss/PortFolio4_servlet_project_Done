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
    private final AdminDAO adminDAO;
    private final TokenGenerator tokenGenerator;
    private final PasswordHashing passwordHashing;

    // 생성자를 통한 의존성 주입
    public AdminLoginAction(AdminDAO adminDAO, TokenGenerator tokenGenerator, PasswordHashing passwordHashing) {
        this.adminDAO = adminDAO;
        this.tokenGenerator = tokenGenerator;
        this.passwordHashing = passwordHashing;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        String adminId = request.getParameter("adminId");
        String adminPassword = passwordHashing.hashPassword(request.getParameter("adminPassword"));
//        String adminPassword = request.getParameter("adminPassword");
        
        int result = adminDAO.adminCheck(adminId, adminPassword);

        // 실제 로그인 처리 로직을 여기에 구현
        if (result > 0) {
            
            String adminToken = tokenGenerator.generateJwtToken(adminId);

            request.getSession().setAttribute("adminToken", adminToken);
            System.out.println(adminToken + "PPPPPPPPPPPPP");
            response.getWriter().write(adminToken);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 인증 실패 상태코드 반환
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
