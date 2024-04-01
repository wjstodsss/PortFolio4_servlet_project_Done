package com.blacksmith.banchan.product.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.product.dao.ProductDAO;
import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;

public class ProductDeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO pVo = pDao.selectProductByCode(code);
		request.setAttribute("product", pVo);
<<<<<<< HEAD
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/product/productDelete.jsp");
=======
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/productDelete.jsp");
>>>>>>> develop
		dispatcher.forward(request, response);
	}

}
