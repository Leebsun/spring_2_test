package com.iu.s2_test;

public class Movie {
	private String title;
	private int price;
	private double point;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title, int price, double point) {
		this.title=title;
		this.price=price;
		this.point=point;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	

}
