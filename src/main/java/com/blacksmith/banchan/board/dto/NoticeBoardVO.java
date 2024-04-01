package com.blacksmith.banchan.board.dto;


import java.sql.Timestamp;

public class NoticeBoardVO {
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
		return "noticeBoardVO [id=" + id + ", title=" + title + ", author=" + author + ", password=" + password
				+ ", content=" + content + ", imageUrl=" + imageUrl + ", readCount=" + readCount + ", datePosted="
				+ datePosted + "]";
	}
}
