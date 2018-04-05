package com.niit.model;

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
public class BlogComment {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="blogcomment_sequence")
	@SequenceGenerator(name="blogcomment_sequence", sequenceName= "blogcomment_seq", initialValue= 1, allocationSize= 1)
	private int blogcommentId;
	private String blogcommentText;
	private String loginName;
	private int blogId;
	@Temporal(TemporalType.DATE)
	private Date blogcommentDate;
	
	public int getBlogcommentId() {
		return blogcommentId;
	}
	public String getBlogcommentText() {
		return blogcommentText;
	}

	public void setBlogcommentText(String blogcommentText) {
		this.blogcommentText = blogcommentText;
	}

	public Date getBlogcommentDate() {
		return blogcommentDate;
	}

	public void setBlogcommentDate(Date blogcommentDate) {
		this.blogcommentDate = blogcommentDate;
	}

	public void setBlogcommentId(int blogcommentId) {
		this.blogcommentId = blogcommentId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
}
