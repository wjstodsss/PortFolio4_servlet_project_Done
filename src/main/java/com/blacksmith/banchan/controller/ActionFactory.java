package com.blacksmith.banchan.controller;

import com.blacksmith.banchan.admin.action.AdminLoginAction;
import com.blacksmith.banchan.admin.action.BuyInfo;
import com.blacksmith.banchan.admin.action.DeliveryInfo;
import com.blacksmith.banchan.admin.dao.AdminDAO;
import com.blacksmith.banchan.board.action.BoardPageAction;
import com.blacksmith.banchan.board.action.FaqBoardAction;
import com.blacksmith.banchan.board.action.NoticeBoardAction;
import com.blacksmith.banchan.board.action.QnaBoardAction;
import com.blacksmith.banchan.board.action.QnaDeleteAction;
import com.blacksmith.banchan.board.action.QnaDetailAction;
import com.blacksmith.banchan.board.action.QnaUpdateAction;
import com.blacksmith.banchan.board.action.QnaWriteAction;
import com.blacksmith.banchan.board.action.ReviewBoardAction;
import com.blacksmith.banchan.board.action.ReviewDeleteAction;
import com.blacksmith.banchan.board.action.ReviewDetailAction;
import com.blacksmith.banchan.board.action.ReviewUpdateAction;
import com.blacksmith.banchan.board.action.ReviewWriteAction;
import com.blacksmith.banchan.login.action.IdCheck;
import com.blacksmith.banchan.login.action.LoginAction;
import com.blacksmith.banchan.login.action.LoginFormAction;
import com.blacksmith.banchan.login.action.LogoutAction;
import com.blacksmith.banchan.login.action.RegisterAction;
import com.blacksmith.banchan.login.action.RegisterFormAction;
import com.blacksmith.banchan.login.service.PasswordHashing;
import com.blacksmith.banchan.payment.action.OrderCompleteAction;
import com.blacksmith.banchan.payment.action.PaymentAction;
import com.blacksmith.banchan.shopping.action.PaymentFormAction;
import com.blacksmith.banchan.shopping.action.PrePaymentAction;
import com.blacksmith.banchan.shopping.action.ProductPageAction;
import com.blacksmith.banchan.shopping.action.ProductSearch;
import com.blacksmith.banchan.shopping.action.ProductSetAction;
import com.blacksmith.banchan.shopping.action.ProductViewAction;
import com.blacksmith.banchan.util.Action;
import com.blacksmith.banchan.util.TokenGenerator;

public class ActionFactory {
	
	AdminDAO adminDAO = new AdminDAO();
	TokenGenerator tokenGenerator = new TokenGenerator();
	PasswordHashing passwordHashing = new PasswordHashing();
	
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
		} else if (command.equals("admin_login")){
			action = new AdminLoginAction(adminDAO, tokenGenerator, passwordHashing);
		} else if (command.equals("logout")){
			action = new LogoutAction();
		} else if (command.equals("index")){
			action = new ProductPageAction();
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
		} else if (command.equals("admin_login_form")){
			action = new LoginFormAction();
		} else if (command.equals("search")){
			action = new ProductSearch();
		} else if (command.equals("info")){
			action = new DeliveryInfo();
		} else if (command.equals("buy-info")){
			action = new BuyInfo();
		} else if (command.equals("pre-payment")){
			action = new PrePaymentAction();
		} else if (command.equals("payment-form")){
			action = new PaymentFormAction();
		} else if (command.equals("product-view")){
			action = new ProductViewAction();
		} else if (command.equals("order-complete")){
			action = new OrderCompleteAction();
		} else if (command.equals("product_set")){
			action = new ProductSetAction();
		} else if (command.equals("payment")){
			action = new PaymentAction();
		} else if (command.equals("write_qna")){
			action = new QnaWriteAction();
		} else if (command.equals("detail_qna")){
			action = new QnaDetailAction();
		} else if (command.equals("update_qna")){
			action = new QnaUpdateAction();
		} else if (command.equals("delete_qna")){
			action = new QnaDeleteAction();
		} else if (command.equals("write_review")){
			action = new ReviewWriteAction();
		} else if (command.equals("detail_review")){
			action = new ReviewDetailAction();
		} else if (command.equals("update_review")){
			action = new ReviewUpdateAction();
		} else if (command.equals("delete_review")){
			action = new ReviewDeleteAction();
		} 
		
		return action;
	}
}
