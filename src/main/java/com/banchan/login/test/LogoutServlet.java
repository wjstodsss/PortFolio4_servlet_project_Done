package com.banchan.login.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션을 가져옵니다.
        HttpSession session = request.getSession(false);
<<<<<<< HEAD
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
=======
        
>>>>>>> develop
        if (session != null) {
            // 세션에서 토큰을 삭제합니다.
            session.removeAttribute("token");
            session.invalidate(); // 옵션: 세션 자체를 무효화합니다.
            
            // 클라이언트에게 로그아웃 성공 메시지를 응답합니다.
            response.getWriter().write("Logout successful");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 세션이 없는 경우에는 이미 로그아웃된 상태입니다.
            response.getWriter().write("No active session found. You are already logged out.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}