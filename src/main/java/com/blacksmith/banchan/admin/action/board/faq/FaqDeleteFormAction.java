package com.blacksmith.banchan.admin.action.board.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.FaqBoardDAO;
import com.blacksmith.banchan.board.dto.FaqBoardVO;
import com.blacksmith.banchan.util.Action;

public class FaqDeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		FaqBoardDAO pDao = FaqBoardDAO.getInstance();
		FaqBoardVO pVo = pDao.selectOneBoardById(id);
		request.setAttribute("board", pVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/board/faq/admin-faq-delete.jsp");
		dispatcher.forward(request, response);
	}

}
