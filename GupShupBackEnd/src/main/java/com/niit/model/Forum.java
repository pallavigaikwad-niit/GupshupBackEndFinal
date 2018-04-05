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
public class Forum {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="forum_sequence")
	@SequenceGenerator(name="forum_sequence", sequenceName= "forum_seq", initialValue= 1, allocationSize= 1)
	private int forumId;
	private String forumName;
	private String forumContent;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	private String loginName;
	private String status;

	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
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
