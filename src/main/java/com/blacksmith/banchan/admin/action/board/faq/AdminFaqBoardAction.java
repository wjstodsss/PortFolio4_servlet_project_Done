package com.blacksmith.banchan.admin.action.board.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.FaqBoardDAO;
import com.blacksmith.banchan.board.dto.FaqBoardVO;
import com.blacksmith.banchan.util.Action;

public class AdminFaqBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		FaqBoardDAO bDao = FaqBoardDAO.getInstance();
	    List<FaqBoardVO> boardList = bDao.selectAllBoards();
	    request.setAttribute("boardList", boardList);
	    System.out.println(boardList);
	    
		String url = "/views/admin/board/admin-faq.jsp";
	    System.out.println(url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	    
	}


}
