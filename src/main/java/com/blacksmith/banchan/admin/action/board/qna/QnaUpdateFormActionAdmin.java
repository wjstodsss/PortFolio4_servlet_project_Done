package com.blacksmith.banchan.admin.action.board.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.QnaBoardDAO;
import com.blacksmith.banchan.board.dto.QnaBoardVO;
import com.blacksmith.banchan.util.Action;

public class QnaUpdateFormActionAdmin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));


		QnaBoardDAO pDao = QnaBoardDAO.getInstance();
		QnaBoardVO pVo = pDao.selectOneBoardById(id);
		System.out.println(pVo);
		request.setAttribute("board", pVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/board/qna/admin-qna-update.jsp");
		dispatcher.forward(request, response);
	}


}
