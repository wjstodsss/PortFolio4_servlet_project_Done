package com.blacksmith.banchan.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.QnaBoardDAO;
import com.blacksmith.banchan.board.dto.QnaBoardVO;
import com.blacksmith.banchan.util.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class QnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		String detailImageUrl = multi.getFilesystemName("detailImageUrl");
		if (detailImageUrl == null) {
			detailImageUrl = multi.getParameter("nonmakeImg");
		}
		
		QnaBoardVO bVo = new QnaBoardVO();
		bVo.setId(Integer.parseInt(multi.getParameter("detailId")));
		bVo.setTitle(multi.getParameter("detailTitle"));
		bVo.setAuthor(multi.getParameter("detailAuthor"));
		bVo.setPassword(multi.getParameter("detailPassword"));
		bVo.setImageUrl(detailImageUrl);
		bVo.setContent(multi.getParameter("detailContent"));
		QnaBoardDAO bDao = QnaBoardDAO.getInstance();
		
		bDao.updateBoard(bVo);
		
		String url = "/views/board/board.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
