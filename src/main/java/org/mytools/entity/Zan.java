package org.mytools.entity;

public class Zan {
	private String usermail;
	private String tidingsid;
	private String zan = "已赞";
	private String nozan = "赞一下";
	private String z;
	

	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public String getZan() {
		return zan;
	}

	public void setZan(String zan) {
		this.zan = zan;
	}

	public String getNozan() {
		return nozan;
	}

	public void setNozan(String nozan) {
		this.nozan = nozan;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getTidingsid() {
		return tidingsid;
	}

	public void setTidingsid(String tidingsid) {
		this.tidingsid = tidingsid;
	}

	@Override
	public String toString() {
		return "Zan [usermail=" + usermail + ", tidingsid=" + tidingsid + ", zan=" + zan + ", nozan=" + nozan + ", z="
				+ z + "]";
	}



}
