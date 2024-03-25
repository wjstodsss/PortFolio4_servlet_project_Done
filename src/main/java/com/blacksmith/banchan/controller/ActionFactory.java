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
import com.blacksmith.banchan.product.action.ProductListAction;
import com.blacksmith.banchan.util.Action;


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
		}
		
		return action;
	}
}
