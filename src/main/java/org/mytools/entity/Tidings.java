package org.mytools.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;
@Component
public class Tidings {
	private String tidingsid;
	private String usermail;
	private String username;
	private String usericon;
	private Timestamp senddate;
	private String tidings;
	private int support;
	
	
	public int getSupport() {
		return support;
	}
	public void setSupport(int support) {
		this.support = support;
	}
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
	public String getUsericon() {
		return usericon;
	}
	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	public Timestamp getSenddate() {
		return senddate;
	}
	public void setSenddate(Timestamp timestamp) {
		this.senddate = timestamp;
	}
	public String getTidings() {
		return tidings;
	}
	public void setTidings(String tidings) {
		this.tidings = tidings;
	}
	@Override
	public String toString() {
		return "Tidings [tidingsid=" + tidingsid + ", usermail=" + usermail + ", username=" + username + ", usericon="
				+ usericon + ", senddate=" + senddate + ", tidings=" + tidings + ", support=" + support + "]";
	}
	
}
