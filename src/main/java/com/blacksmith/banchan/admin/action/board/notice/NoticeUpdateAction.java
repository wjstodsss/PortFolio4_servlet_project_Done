package com.blacksmith.banchan.admin.action.board.notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.NoticeBoardDAO;
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.util.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class NoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ServletContext context = request.getServletContext();

		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		int id = Integer.parseInt(multi.getParameter("id"));
		String title = multi.getParameter("title");
		String author = multi.getParameter("author");
		String password = multi.getParameter("password");
		String content = multi.getParameter("content");
		String imageUrl = multi.getFilesystemName("imageUrl");
		
		NoticeBoardVO pVo = new NoticeBoardVO();
		
	
		pVo.setId(id);
		pVo.setTitle(title);
		pVo.setAuthor(author);
		pVo.setPassword(password);
		pVo.setContent(content);
		pVo.setImageUrl(imageUrl);

		NoticeBoardDAO pDao = NoticeBoardDAO.getInstance();
		pDao.updateBoard(pVo);

		response.sendRedirect("banchan?command=notice_list");

	}

}
