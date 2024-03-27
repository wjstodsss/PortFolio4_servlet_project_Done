package com.blacksmith.banchan.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.util.Action;

public class ReviewDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("detailId")+"kkkkkkkkkkkkkkkkkkkk");
		int id=Integer.parseInt(request.getParameter("detailId"));
		ReviewBoardDAO bDao=ReviewBoardDAO.getInstance();
		bDao.deleteBoard(id);
	}

}
