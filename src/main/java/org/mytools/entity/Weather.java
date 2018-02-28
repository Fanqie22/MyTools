package org.mytools.entity;

public class Weather {
	private String times;
	private String local;
	private String week;
	private String weather;
	private String temperature;
	private String icon;
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "weather [times=" + times + ", local=" + local + ", week=" + week + ", weather=" + weather
				+ ", temperature=" + temperature + ", icon=" + icon + "]";
	}
	
	
}
