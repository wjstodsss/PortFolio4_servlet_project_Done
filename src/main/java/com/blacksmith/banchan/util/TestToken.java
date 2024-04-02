package com.blacksmith.banchan.util;

public class TestToken {

	public static void main(String[] args) {
		
		String ok = TokenGenerator.generateJwtToken();
		
		System.out.println(ok);

	}

}
