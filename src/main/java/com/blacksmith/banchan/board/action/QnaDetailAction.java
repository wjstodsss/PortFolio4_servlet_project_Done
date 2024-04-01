package com.blacksmith.banchan.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.QnaBoardDAO;
import com.blacksmith.banchan.board.dto.QnaBoardVO;
import com.blacksmith.banchan.util.Action;
import com.google.gson.Gson;

public class QnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		QnaBoardDAO bDao = QnaBoardDAO.getInstance();
		bDao.updateReadCount(id);
		QnaBoardVO board = bDao.selectOneBoardById(id);
		Gson gson = new Gson();
	    String json = gson.toJson(board);
		request.setAttribute("board", board);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);		
	}

}
