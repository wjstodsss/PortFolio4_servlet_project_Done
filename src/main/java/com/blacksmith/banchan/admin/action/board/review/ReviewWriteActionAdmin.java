package com.blacksmith.banchan.admin.action.board.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.ReviewBoardDAO;
import com.blacksmith.banchan.board.dto.ReviewBoardVO;
import com.blacksmith.banchan.util.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteActionAdmin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ServletContext context = request.getServletContext();

		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());


		String title = multi.getParameter("title");
		String author = multi.getParameter("author");
		String password = multi.getParameter("password");
		String content = multi.getParameter("content");
		String imageUrl = multi.getFilesystemName("imageUrl");
		ReviewBoardVO pVo = new ReviewBoardVO();
		pVo.setTitle(title);
		pVo.setAuthor(author);
		pVo.setPassword(password);
		pVo.setContent(content);
		pVo.setImageUrl(imageUrl);

		ReviewBoardDAO pDao = ReviewBoardDAO.getInstance();
		pDao.insertBoard(pVo);

		response.sendRedirect("admin?command=review_list");

	}

}
