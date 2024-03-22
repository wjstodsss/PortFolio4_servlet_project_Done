//package com.banchan.login.test;
//
//import java.io.IOException;
//import java.security.SecureRandom;
//import java.util.Base64;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        
//        // 실제 로그인 처리 로직을 여기에 구현
//        if (username.equals("user") && password.equals("1234")) {
//            // 토큰 생성 (여기서는 단순히 무작위 문자열로 토큰을 생성)
//            String token = generateToken();
//            System.out.println("ok");
//            
//            // 클라이언트에게 토큰을 반환
//            response.getWriter().write(token);
//            response.setStatus(HttpServletResponse.SC_OK);
//            System.out.println(token);
//        } else {
//            // 인증 실패 상태코드 반환
//        	System.out.println(username);
//        	System.out.println(password);
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
//    
//    // 토큰 생성 메서드
//    public static String generateToken() {
//        // 무작위 바이트 배열 생성
//        byte[] randomBytes = new byte[32];
//        new SecureRandom().nextBytes(randomBytes);
//
//        // 바이트 배열을 Base64 인코딩하여 문자열로 변환하여 반환
//        return Base64.getEncoder().encodeToString(randomBytes);
//    }
//}
