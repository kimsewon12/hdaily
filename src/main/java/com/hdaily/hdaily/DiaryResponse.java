package com.hdaily.hdaily;

public class DiaryResponse {//서버->클라이언트(서버에서 나가는 데이터)
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
