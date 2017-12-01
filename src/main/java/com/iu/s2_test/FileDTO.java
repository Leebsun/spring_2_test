package com.iu.s2_test;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {

	private String title;
	private MultipartFile [] f1;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile[] getF1() {
		return f1;
	}
	public void setF1(MultipartFile[] f1) {
		this.f1 = f1;
	}
	
	
}
