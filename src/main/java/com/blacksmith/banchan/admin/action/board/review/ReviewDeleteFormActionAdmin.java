package com.blacksmith.banchan.admin.action.board.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.board.dto.ReviewBoardVO;
import com.blacksmith.banchan.util.Action;

public class ReviewDeleteFormActionAdmin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		ReviewBoardDAO pDao = ReviewBoardDAO.getInstance();
		ReviewBoardVO pVo = pDao.selectOneBoardById(id);
		request.setAttribute("board", pVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/board/review/admin-review-delete.jsp");
		dispatcher.forward(request, response);
	}

}
