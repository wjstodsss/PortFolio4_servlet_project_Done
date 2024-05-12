package com.blacksmith.banchan.admin.action.board.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.NoticeBoardDAO;
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.util.Action;

public class NoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		
		NoticeBoardDAO pDao = NoticeBoardDAO.getInstance();
		NoticeBoardVO pVo = pDao.selectOneBoardById(id);
		System.out.println(pVo);
		request.setAttribute("board", pVo);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/board/notice/admin-notice-update.jsp");
		dispatcher.forward(request, response);
	}


}
