package com.myspring.tibet.board.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("qnaVO")
public class QnaVO {
	private Integer qna_num;
	private String qna_title;
	private String qna_content;
	private Date qna_date;
	private int qna_lock;
	private String user_id;
	private String product_num;
	private Integer qna_pw;
	private String qna_img1;
	private String qna_img2;
	private String qna_img3;
	
	public Integer getQna_num() {
		return qna_num;
	}
	public void setQna_num(Integer qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	public int getQna_lock() {
		return qna_lock;
	}
	public void setQna_lock(int qna_lock) {
		this.qna_lock = qna_lock;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_num() {
		return product_num;
	}
	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	public Integer getQna_pw() {
		return qna_pw;
	}
	public void setQna_pw(Integer qna_pw) {
		this.qna_pw = qna_pw;
	}
	public String getQna_img1() {
		return qna_img1;
	}
	public void setQna_img1(String qna_img1) {
		this.qna_img1 = qna_img1;
	}
	public String getQna_img2() {
		return qna_img2;
	}
	public void setQna_img2(String qna_img2) {
		this.qna_img2 = qna_img2;
	}
	public String getQna_img3() {
		return qna_img3;
	}
	public void setQna_img3(String qna_img3) {
		this.qna_img3 = qna_img3;
	}
}
