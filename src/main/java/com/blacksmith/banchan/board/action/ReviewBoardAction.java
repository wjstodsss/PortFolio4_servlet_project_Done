package com.blacksmith.banchan.board.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.board.dto.ReviewBoardVO;
import com.blacksmith.banchan.board.dto.ReviewBoardVO;
import com.blacksmith.banchan.util.Action;
import com.blacksmith.banchan.util.PageHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ReviewBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    
	    Integer page = getParameterOrDefault(request.getParameter("page"), 1);
	    Integer pageSize = getParameterOrDefault(request.getParameter("pageSize"), 5);
	    
	    map.put("offset", (page-1)*pageSize);
	    map.put("pageSize", pageSize);
	    ReviewBoardDAO bDao = ReviewBoardDAO.getInstance();
	    List<ReviewBoardVO> boardList = bDao.selectPage(map);
	    
	    int totalCnt = bDao.getCount();
	    PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);
	    
	    // 응답 데이터를 JSON 형식으로 변환
	    Gson gson = new Gson();
	    JsonObject jsonResponse = new JsonObject();
	    jsonResponse.add("boardList", gson.toJsonTree(boardList)); // 게시글 목록
	    jsonResponse.add("pageHandler", gson.toJsonTree(pageHandler)); // 페이지 핸들러 정보
	    
	    // 클라이언트에게 JSON 응답을 반환
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse.toString());
	}

	private Integer getParameterOrDefault(String paramValue, Integer defaultValue) {
	    if (paramValue == null || paramValue.isEmpty()) {
	        return defaultValue;
	    }
	    for (char c : paramValue.toCharArray()) {
	        if (!Character.isDigit(c)) {
	            return defaultValue;
	        }
	    }
	    return Integer.parseInt(paramValue);
	}
}


