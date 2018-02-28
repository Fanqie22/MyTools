package org.mytools.entity;

import org.springframework.stereotype.Component;

@Component
public class Friends {
	private String friendmail;

	public String getFriendmail() {
		return friendmail;
	}

	public void setFriendmail(String friendmail) {
		this.friendmail = friendmail;
	}

	@Override
	public String toString() {
		return "Friends [friendmail=" + friendmail + "]";
	}
	
	
}
