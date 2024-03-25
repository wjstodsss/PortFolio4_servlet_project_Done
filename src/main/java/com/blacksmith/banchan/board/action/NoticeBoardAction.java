package com.blacksmith.banchan.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.NoticeBoardDAO;
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.util.Action;
import com.google.gson.Gson;

public class NoticeBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    NoticeBoardDAO bDao = NoticeBoardDAO.getInstance();
	    List<NoticeBoardVO> boardList = bDao.selectAllBoards();
	    
	    // 응답 데이터를 JSON 형식으로 변환
	    Gson gson = new Gson();
	    String json = gson.toJson(boardList);
	    // 클라이언트에게 JSON 응답을 반환
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}


}
