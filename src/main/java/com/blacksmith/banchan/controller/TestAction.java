package com.blacksmith.banchan.controller;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.util.Action;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class TestAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }
	    String jsonString = sb.toString();
	    System.out.println(jsonString);
	    // JSON 문자열 파싱
	    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
		
//		String itemId = request.getParameter("itemId");
//        String itemQuantity = request.getParameter("itemQuantity");
//        
//        System.out.println(itemId);
//        System.out.println(itemQuantity);

	    // 클라이언트로 응답 전송
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write("Cart items received successfully");
	}



}
