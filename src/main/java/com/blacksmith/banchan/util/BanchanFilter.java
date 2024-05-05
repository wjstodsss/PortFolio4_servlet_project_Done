package com.blacksmith.banchan.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/banchan/*")
public class BanchanFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 메소드
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 요청의 쿼리스트링을 확인하여 특정 동작 수행
        String command = request.getParameter("command");
        if ("admin".equals(command)) {
            // admin 커맨드에 대한 처리
            // 예: 특정 권한을 가진 사용자만 접근을 허용하도록 처리할 수 있습니다.
            if (userHasAdminPermission(request)) {
                filterChain.doFilter(request, response); // 다음 필터로 요청 전달
            } else {
                response.sendRedirect("access_denied.html"); // 권한 없음 페이지로 리다이렉트
            }
        } else {
            // 다른 커맨드에 대한 처리
            // 예: 특정 작업 수행
            // 다음 필터로 요청 전달
            filterChain.doFilter(request, response);
        }
    }

    private boolean userHasAdminPermission(HttpServletRequest request) {
        // 여기서 사용자가 admin 권한을 가졌는지 확인하는 로직을 구현
        // 이 예제에서는 간단하게 모든 요청을 허용하도록 함
        return false;
    }

    @Override
    public void destroy() {
        // 필터 종료 시 호출되는 메소드
    }
}
