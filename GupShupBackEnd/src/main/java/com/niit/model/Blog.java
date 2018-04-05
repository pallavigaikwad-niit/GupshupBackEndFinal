package com.niit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Blog implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="blog_sequence")
	@SequenceGenerator(name="blog_sequence", sequenceName= "blog_seq", initialValue= 1, allocationSize= 1)
	private int blogId;
	private String blogName;
	private String blogContent;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private String loginName;
	private String status;
	private int likes;
	
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}