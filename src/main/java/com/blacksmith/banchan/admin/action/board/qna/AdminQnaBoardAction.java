package com.blacksmith.banchan.admin.action.board.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.QnaBoardDAO;
import com.blacksmith.banchan.board.dto.QnaBoardVO;
import com.blacksmith.banchan.util.Action;

public class AdminQnaBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		QnaBoardDAO bDao = QnaBoardDAO.getInstance();
	    List<QnaBoardVO> boardList = bDao.selectAllBoards();
	    request.setAttribute("boardList", boardList);
	    System.out.println(boardList);
	    
		String url = "/views/admin/board/admin-qna.jsp";
	    System.out.println(url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	    
	}


}
