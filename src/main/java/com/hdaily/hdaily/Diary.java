package com.hdaily.hdaily;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity //JPA에게 "이 클래스 모양대로 DB에 테이블을 만들어라"라고 명령.
public class Diary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호는 1번부터 올라가도록 하라.
	private Long id;
	
	private String date;
	private String content;
	
	public Diary() {}
	
	public Diary(String date, String content) {
		this.date = date;
		this.content = content;
	}
	
	public Long getId() { return id; }
	public String getDate() { return date; }
	public String getContent() { return content; }
	
}
