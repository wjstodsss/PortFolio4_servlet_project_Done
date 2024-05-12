package com.blacksmith.banchan.util;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	 // 웹 애플리케이션의 컨텍스트 경로 가져오기
        String contextPath = sce.getServletContext().getRealPath("/");
        System.out.println(contextPath);
        // 파일 업로드 디렉토리 경로 설정
        String uploadDirectory = contextPath + "upload";
        System.out.println(uploadDirectory);
        // 파일 업로드 디렉토리 생성
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("파일 업로드 디렉토리 생성 완료");
        }
        System.out.println("웹 애플리케이션 초기화 완료");
    }

}
