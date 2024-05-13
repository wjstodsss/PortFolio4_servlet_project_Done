package com.blacksmith.banchan.admin.action.board.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.board.dto.ReviewBoardVO;
import com.blacksmith.banchan.util.Action;

public class AdminReviewBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ReviewBoardDAO bDao = ReviewBoardDAO.getInstance();
	    List<ReviewBoardVO> boardList = bDao.selectAllBoards();
	    request.setAttribute("boardList", boardList);

	  
		String url = "/views/admin/board/review/admin-review.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	    
	}


}
