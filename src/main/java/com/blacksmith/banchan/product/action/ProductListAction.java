package com.blacksmith.banchan.product.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.NoticeBoardDAO;
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.util.Action;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeBoardDAO pDao = NoticeBoardDAO.getInstance();
		List<NoticeBoardVO> productList = pDao.selectAllBoards();
		request.setAttribute("productList", productList);
		
		System.out.println(request.getAttribute("productList"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/product.jsp");
		dispatcher.forward(request, response);

	}

}
