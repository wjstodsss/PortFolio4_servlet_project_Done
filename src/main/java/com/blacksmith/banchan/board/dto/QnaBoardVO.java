package com.blacksmith.banchan.board.dto;


import java.sql.Timestamp;

public class QnaBoardVO {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> develop
	private Integer id;
    private String title;
    private String author;
    private String password;
    private String content;
    private String imageUrl;
    private Integer readCount;
    private Timestamp datePosted;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Timestamp getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	@Override
	public String toString() {
		return "FaqBoardVO [id=" + id + ", title=" + title + ", author=" + author + ", password=" + password
				+ ", content=" + content + ", imageUrl=" + imageUrl + ", readCount=" + readCount + ", datePosted="
				+ datePosted + "]";
	}
<<<<<<< HEAD
=======
=======
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

>>>>>>> develop
>>>>>>> develop
}
