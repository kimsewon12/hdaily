package com.hdaily.hdaily;

public class DiaryResponse {
	private String date;
	private String content;
	
	public DiaryResponse(String date, String content) {
		this.date = date;
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}
}
