package com.blacksmith.banchan.admin.action.board.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.NoticeBoardDAO;
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.product.dao.ProductDAO;
import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;
import com.google.gson.Gson;

public class AdminNoticeBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		NoticeBoardDAO bDao = NoticeBoardDAO.getInstance();
	    List<NoticeBoardVO> boardList = bDao.selectAllBoards();
	    request.setAttribute("boardList", boardList);
	    
	   
	
		
		String url = "/views/admin/board/notice/admin-notice.jsp";
	    System.out.println(url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	    
	}


}
