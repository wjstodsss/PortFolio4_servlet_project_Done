package com.blacksmith.banchan.admin.action.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.board.dao.QnaBoardDAO;
import com.blacksmith.banchan.util.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class QnaDeleteActionAdmin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		ServletContext context = request.getServletContext();

		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());


		int id = Integer.parseInt(multi.getParameter("id"));

		QnaBoardDAO pDao = QnaBoardDAO.getInstance();

		pDao.deleteBoard(id);

		response.sendRedirect("banchan?command=qna_list");
	}

}
