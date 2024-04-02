package com.blacksmith.banchan.controller;

import com.blacksmith.banchan.admin.action.AdminLoginAction;
import com.blacksmith.banchan.admin.action.AdminPageAction;
import com.blacksmith.banchan.admin.action.board.faq.AdminFaqBoardAction;
import com.blacksmith.banchan.admin.action.board.faq.FaqDeleteAction;
import com.blacksmith.banchan.admin.action.board.faq.FaqDeleteFormAction;
import com.blacksmith.banchan.admin.action.board.faq.FaqUpdateAction;
import com.blacksmith.banchan.admin.action.board.faq.FaqUpdateFormAction;
import com.blacksmith.banchan.admin.action.board.faq.FaqWriteAction;
import com.blacksmith.banchan.admin.action.board.notice.AdminNoticeBoardAction;
import com.blacksmith.banchan.admin.action.board.notice.NoticeDeleteAction;
import com.blacksmith.banchan.admin.action.board.notice.NoticeDeleteFormAction;
import com.blacksmith.banchan.admin.action.board.notice.NoticeUpdateAction;
import com.blacksmith.banchan.admin.action.board.notice.NoticeUpdateFormAction;
import com.blacksmith.banchan.admin.action.board.notice.NoticeWriteAction;
import com.blacksmith.banchan.admin.action.board.notice.NoticeWriteFormAction;
import com.blacksmith.banchan.admin.action.board.qna.AdminQnaBoardAction;
import com.blacksmith.banchan.admin.action.board.qna.QnaDeleteActionAdmin;
import com.blacksmith.banchan.admin.action.board.qna.QnaDeleteFormActionAdmin;
import com.blacksmith.banchan.admin.action.board.qna.QnaUpdateActionAdmin;
import com.blacksmith.banchan.admin.action.board.qna.QnaUpdateFormActionAdmin;
import com.blacksmith.banchan.admin.action.board.qna.QnaWriteActionAdmin;
import com.blacksmith.banchan.admin.action.board.qna.QnaWriteFormActionAdmin;
import com.blacksmith.banchan.admin.action.board.review.AdminReviewBoardAction;
import com.blacksmith.banchan.admin.action.board.review.ReviewDeleteActionAdmin;
import com.blacksmith.banchan.admin.action.board.review.ReviewDeleteFormActionAdmin;
import com.blacksmith.banchan.admin.action.board.review.ReviewUpdateActionAdmin;
import com.blacksmith.banchan.admin.action.board.review.ReviewUpdateFormActionAdmin;
import com.blacksmith.banchan.admin.action.board.review.ReviewWriteActionAdmin;
import com.blacksmith.banchan.admin.action.board.review.ReviewWriteFormActionAdmin;
import com.blacksmith.banchan.board.action.BoardPageAction;
import com.blacksmith.banchan.board.action.FaqBoardAction;
import com.blacksmith.banchan.board.action.FaqWriteFormAction;
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
import com.blacksmith.banchan.product.action.ProductDeleteAction;
import com.blacksmith.banchan.product.action.ProductDeleteFormAction;
import com.blacksmith.banchan.product.action.ProductListAction;
import com.blacksmith.banchan.product.action.ProductUpdateAction;
import com.blacksmith.banchan.product.action.ProductUpdateFormAction;
import com.blacksmith.banchan.product.action.ProductWriteAction;
import com.blacksmith.banchan.product.action.ProductWriteFormAction;
import com.blacksmith.banchan.shopping.action.ProductPageAction;
import com.blacksmith.banchan.shopping.action.ProductSetAction;
import com.blacksmith.banchan.util.Action;
import com.blacksmith.banchan.util.MultiUploadTestAction;
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
		} else if (command.equals("product_set")){
			action = new ProductSetAction();
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
		} else if (command.equals("admin_login_form")){
			action = new LoginFormAction();
		} else if (command.equals("admin_login")){
			action = new AdminLoginAction();
		} else if (command.equals("notice_list")){
			action = new AdminNoticeBoardAction();
		} else if (command.equals("qna_list")){
			action = new AdminQnaBoardAction();
		} else if (command.equals("faq_list")){
			action = new AdminFaqBoardAction();
		} else if (command.equals("review_list")){
			action = new AdminReviewBoardAction();
		} else if (command.equals("notice_write_form")){
			action = new NoticeWriteFormAction();
		} else if (command.equals("notice_write")){
			action = new NoticeWriteAction();
		} else if (command.equals("notice_update_form")){
			action = new NoticeUpdateFormAction();
		} else if (command.equals("notice_update")){
			action = new NoticeUpdateAction();
		} else if (command.equals("notice_delete_form")){
			action = new NoticeDeleteFormAction();
		} else if (command.equals("notice_delete")){
			action = new NoticeDeleteAction();
		} else if (command.equals("qna_write_form")){
			action = new QnaWriteFormActionAdmin();
		} else if (command.equals("qna_write")){
			action = new QnaWriteActionAdmin();
		} else if (command.equals("qna_update_form")){
			action = new QnaUpdateFormActionAdmin();
		} else if (command.equals("qna_update")){
			action = new QnaUpdateActionAdmin();
		} else if (command.equals("qna_delete_form")){
			action = new QnaDeleteFormActionAdmin();
		} else if (command.equals("qna_delete")){
			action = new QnaDeleteActionAdmin();
		} else if (command.equals("faq_write_form")){
			action = new FaqWriteFormAction();
		} else if (command.equals("faq_write")){
			action = new FaqWriteAction();
		} else if (command.equals("faq_update_form")){
			action = new FaqUpdateFormAction();
		} else if (command.equals("faq_update")){
			action = new FaqUpdateAction();
		} else if (command.equals("faq_delete_form")){
			action = new FaqDeleteFormAction();
		} else if (command.equals("faq_delete")){
			action = new FaqDeleteAction();	
		} else if (command.equals("review_write_form")){
			action = new ReviewWriteFormActionAdmin();
		} else if (command.equals("review_write")){
			action = new ReviewWriteActionAdmin();
		} else if (command.equals("review_update_form")){
			action = new ReviewUpdateFormActionAdmin();
		} else if (command.equals("review_update")){
			action = new ReviewUpdateActionAdmin();
		} else if (command.equals("review_delete_form")){
			action = new ReviewDeleteFormActionAdmin();
		} else if (command.equals("review_delete")){
			action = new ReviewDeleteActionAdmin();
		} 
		
		return action;
	}
}
