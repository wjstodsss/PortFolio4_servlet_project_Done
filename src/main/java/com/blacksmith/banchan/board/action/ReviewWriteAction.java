package com.blacksmith.banchan.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.board.dto.ReviewBoardVO;
import com.blacksmith.banchan.util.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		ReviewBoardVO bVo = new ReviewBoardVO();
		bVo.setTitle(multi.getParameter("title"));
		bVo.setAuthor(multi.getParameter("author"));
		bVo.setPassword(multi.getParameter("password"));
		bVo.setImageUrl(multi.getFilesystemName("imageUrl"));
		bVo.setContent(multi.getParameter("content"));
		ReviewBoardDAO bDao = ReviewBoardDAO.getInstance();
		System.out.println("ff");
		System.out.println(bVo);
		bDao.insertBoard(bVo);

		String url = request.getContextPath() + "banchan?command=board";
        response.sendRedirect(url);

	}

}
