package com.blacksmith.banchan.controller;


import com.blacksmith.banchan.admin.action.AdminPageAction;
import com.blacksmith.banchan.board.action.BoardPageAction;
import com.blacksmith.banchan.board.action.FaqBoardAction;
import com.blacksmith.banchan.board.action.NoticeBoardAction;
import com.blacksmith.banchan.board.action.QnaBoardAction;
import com.blacksmith.banchan.board.action.ReviewBoardAction;
import com.blacksmith.banchan.login.action.IdCheck;
import com.blacksmith.banchan.login.action.IndexAction;
import com.blacksmith.banchan.login.action.LoginAction;
import com.blacksmith.banchan.login.action.LoginFormAction;
import com.blacksmith.banchan.login.action.RegisterAction;
import com.blacksmith.banchan.login.action.RegisterFormAction;
import com.blacksmith.banchan.product.action.ProductDeleteAction;
import com.blacksmith.banchan.product.action.ProductDeleteFormAction;
import com.blacksmith.banchan.product.action.ProductListAction;
import com.blacksmith.banchan.product.action.ProductUpdateAction;
import com.blacksmith.banchan.product.action.ProductUpdateFormAction;
import com.blacksmith.banchan.product.action.ProductWriteAction;
import com.blacksmith.banchan.product.action.ProductWriteFormAction;
import com.blacksmith.banchan.util.Action;
import com.blacksmith.banchan.util.MultiUploadTestAction;
import com.blacksmith.banchan.util.ProductPageTest;
import com.blacksmith.banchan.util.ProductSetTest;
import com.blacksmith.banchan.util.UploadTestAction;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("index")){
			action = new IndexAction();
		} else if (command.equals("member_login")){
			action = new LoginAction();
		} else if (command.equals("register_form")){
			action = new RegisterFormAction();
		} else if (command.equals("register")){
			action = new RegisterAction();
		} else if (command.equals("idCheck")){
			action = new IdCheck();
		} else if (command.equals("board")){
			action = new BoardPageAction();
		} else if (command.equals("notice")){
			action = new NoticeBoardAction();
		} else if (command.equals("qna")){
			action = new QnaBoardAction();
		} else if (command.equals("faq")){
			action = new FaqBoardAction();
		} else if (command.equals("review")){
			action = new ReviewBoardAction();
		} else if (command.equals("admin_page")){
			action = new AdminPageAction();
		} else if (command.equals("product_list")){
			action = new ProductListAction();
		} else if (command.equals("product_write_form")){
			action = new ProductWriteFormAction();
		} else if (command.equals("upload_test")){
			action = new UploadTestAction();
		} else if (command.equals("multiUpload_test")){
			action = new MultiUploadTestAction();
		} else if (command.equals("product_write")){
			action = new ProductWriteAction();
		} else if (command.equals("product_update_form")){
			action = new ProductUpdateFormAction();
		} else if (command.equals("product_update")){
			action = new ProductUpdateAction();
		} else if (command.equals("product_delete_form")){
			action = new ProductDeleteFormAction();
		} else if (command.equals("product_delete")){
			action = new ProductDeleteAction();
		} else if (command.equals("test")){
			action = new ProductSetTest();
		} else if (command.equals("test_page")){
			action = new ProductPageTest();
		}
		
		return action;
	}
}
