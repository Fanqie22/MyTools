package org.mytools.entity;

import java.sql.Timestamp;
import org.springframework.stereotype.Component;

@Component
public class Comments {
	private String tidingsid;
	private String usermail;
	private String username;
	private String comment;
	private Timestamp commentdate;
	
	public String getTidingsid() {
		return tidingsid;
	}
	public void setTidingsid(String tidingsid) {
		this.tidingsid = tidingsid;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Timestamp getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Timestamp commentdate) {
		this.commentdate = commentdate;
	}
	@Override
	public String toString() {
		return "comments [tidingsid=" + tidingsid + ", usermail=" + usermail + ", username=" + username + ", comment="
				+ comment + ", commentdate=" + commentdate + "]";
	}
	
	
}
