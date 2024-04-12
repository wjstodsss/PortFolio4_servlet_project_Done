package com.blacksmith.banchan.shopping.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;

public class ProductViewAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	List<ProductVO> productList = (List<ProductVO>) session.getAttribute("productList");
    	request.setAttribute("productList", productList);
    	
        String url = "/views/shopping/shopping.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

