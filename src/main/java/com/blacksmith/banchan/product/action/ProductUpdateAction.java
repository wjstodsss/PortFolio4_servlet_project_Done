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

public class ProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		String code = multi.getParameter("code");
		String productname = multi.getParameter("productname");
		int price = Integer.parseInt(multi.getParameter("price"));

		int category = Integer.parseInt(multi.getParameter("category"));

		String description = multi.getParameter("description");
		String pictureUrl = multi.getFilesystemName("pictureUrl");

		if (pictureUrl == null) {
			pictureUrl = multi.getParameter("nonmakeImg");
		}

		ProductVO pVo = new ProductVO();
		pVo.setCode(Integer.parseInt(code));
		pVo.setProductName(productname);
		pVo.setPrice(price);

		pVo.setCategory(category);

		pVo.setDescription(description);
		pVo.setPictureUrl(pictureUrl);

		ProductDAO pDao = ProductDAO.getInstance();
		System.out.println(pDao);



		pDao.updateProduct(pVo);

		response.sendRedirect("banchan?command=product_list");

	}

}
