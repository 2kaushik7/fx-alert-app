package com.systemsai.fxalert.notification;

public class AlertEvent {
	private String email;
	private String fxPair;
	private double threshold;
	private double currentRate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFxPair() {
		return fxPair;
	}
	public void setFxPair(String fxPair) {
		this.fxPair = fxPair;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public double getCurrentRate() {
		return currentRate;
	}
	public void setCurrentRate(double currentRate) {
		this.currentRate = currentRate;
	}
	
	
}
