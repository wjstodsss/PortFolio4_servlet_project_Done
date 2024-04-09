package com.blacksmith.banchan.controller;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.util.Action;



public class TestAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StringBuilder sb = new StringBuilder();
//	    BufferedReader reader = request.getReader();
//	    String line;
//	    while ((line = reader.readLine()) != null) {
//	        sb.append(line);
//	    }
//	    String jsonString = sb.toString();
//	    System.out.println(jsonString);
//	    // JSON 문자열 파싱
//	    Gson gson = new Gson();
//	    Item[] items = gson.fromJson(jsonString, Item[].class);
//	    
//	    // 처리할 작업 수행
//	    for (Item item : items) {
//	        System.out.println("Received item: " + item.getId());
//	        System.out.println("Received item: " + item.getQuantity());
//	        // 여기서부터는 받아온 데이터를 활용하여 필요한 작업을 수행할 수 있습니다.
//	    }
		
		
		System.out.println(request.getParameter("cvc"));
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
		    String parameterName = parameterNames.nextElement();
		    System.out.println("Parameter - " + parameterName + ": " + request.getParameter(parameterName));
		}
		
	    
	    System.out.println("ok");
	    
	    
//	    // 클라이언트로 응답 전송
//	    response.setContentType("text/plain");
//	    response.setCharacterEncoding("UTF-8");
//	    response.getWriter().write("Cart items received successfully");
	}



}
