package com.blacksmith.banchan.shopping.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.product.dao.ProductDAO;
import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;

public class ProductPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/views/index.jsp";
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductVO> productList = pDao.selectProductsByCategory(1);
		request.setAttribute("productList", productList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
