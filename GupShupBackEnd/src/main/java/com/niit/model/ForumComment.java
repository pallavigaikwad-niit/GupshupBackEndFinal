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
public class ForumComment {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="forumcomment_sequence")
	@SequenceGenerator(name="forumcomment_sequence", sequenceName= "forumcomment_seq", initialValue= 1, allocationSize= 1)
	private int forumcommentId;
	private String forumcommentText;
	private String loginName;
	private int forumId;
	@Temporal(TemporalType.DATE)
	private Date forumcommentDate;

	public int getForumcommentId() {
		return forumcommentId;
	}
	public void setForumcommentId(int forumcommentId) {
		this.forumcommentId = forumcommentId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getForumcommentText() {
		return forumcommentText;
	}
	public void setForumcommentText(String forumcommentText) {
		this.forumcommentText = forumcommentText;
	}
	
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public Date getForumcommentDate() {
		return forumcommentDate;
	}
	public void setForumcommentDate(Date forumcommentDate) {
		this.forumcommentDate = forumcommentDate;
	}
}
