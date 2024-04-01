package com.blacksmith.banchan.product.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.product.dao.ProductDAO;
import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ServletContext context = request.getServletContext();

		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		String productname = multi.getParameter("productname");
		int price = Integer.parseInt(multi.getParameter("price"));
		String descripation = multi.getParameter("description");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		ProductVO pVo = new ProductVO();
		pVo.setProductName(productname);
		pVo.setPrice(price);
		pVo.setDescription(descripation);
		pVo.setPictureUrl(pictureUrl);

		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(pVo);

		response.sendRedirect("banchan?command=product_list");

	}

}
