package com.blacksmith.banchan.shopping.action;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blacksmith.banchan.controller.CartItems.Item;
import com.blacksmith.banchan.util.Action;
import com.google.gson.Gson;

public class PrePaymentAction implements Action {

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
		Gson gson = new Gson();
		Item[] items = gson.fromJson(jsonString, Item[].class);

		// 처리할 작업 수행
		for (Item item : items) {
			System.out.println("Received item: " + item.getId());
			System.out.println("Received item: " + item.getQuantity());
			// 여기서부터는 받아온 데이터를 활용하여 필요한 작업을 수행할 수 있습니다.
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/shopping/payment.jsp");
		dispatcher.forward(request, response);
	}

}
