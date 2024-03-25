package com.blacksmith.banchan.board.dto;


import java.sql.Timestamp;

public class NoticeBoardVO {
	private int num;
	private String username;
	private String email;
	private String pass;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", username=" + username + ", email=" + email + ", pass=" + pass + ", title="
				+ title + ", content=" + content + ", readcount=" + readcount + ", writedate=" + writedate + "]";
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

}
