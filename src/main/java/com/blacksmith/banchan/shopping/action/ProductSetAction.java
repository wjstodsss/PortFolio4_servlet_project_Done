package com.blacksmith.banchan.shopping.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blacksmith.banchan.product.dao.ProductDAO;
import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;

public class ProductSetAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category = Integer.parseInt(request.getParameter("category"));
		ProductDAO pDao = ProductDAO.getInstance();
		
		List<ProductVO> productList = pDao.selectProductsByCategory(category);
		HttpSession session = request.getSession();
	    session.setAttribute("productList", productList);
		
		response.sendRedirect("banchan?command=product-view");
	}
}
