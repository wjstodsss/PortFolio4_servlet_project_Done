package com.blacksmith.banchan.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletContext;

public class UploadDirectoryFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 작업이 필요한 경우에 구현
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        String savePath = "upload";
        String uploadFilePath = context.getRealPath(savePath);

        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        System.out.println("filter2");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 필터가 소멸될 때 호출되는 메서드
    }
}
