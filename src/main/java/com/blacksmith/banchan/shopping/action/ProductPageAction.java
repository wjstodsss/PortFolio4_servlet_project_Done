package com.blacksmith.banchan.shopping.action;

import java.io.IOException;
import java.util.ArrayList;
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
	    
	    int categoryCount = 8; // 카테고리 개수
	    List<List<ProductVO>> allProductLists = new ArrayList<>();

	    
	    for (int i = 1; i <= categoryCount; i++) {
	        List<ProductVO> productList = pDao.selectProductsByCategoryCountNineLess(i);
	        allProductLists.add(productList);
	    }
	    
	    for (int i = 1; i <= categoryCount; i++) {
	        String attributeName = "productList" + i;
	        request.setAttribute(attributeName, allProductLists.get(i - 1));
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}



}
