package com.blacksmith.banchan.controller;


import com.blacksmith.banchan.login.action.IndexAction;
import com.blacksmith.banchan.login.action.LoginAction;
import com.blacksmith.banchan.login.action.LoginFormAction;
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
		}
		
		return action;
	}
}
