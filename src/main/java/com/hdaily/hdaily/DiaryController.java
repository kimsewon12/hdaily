package com.hdaily.hdaily;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DiaryController {
	
	@GetMapping("/diary")
	//get은 서버에서 데이터 가져오기
	
	public List<DiaryResponse> getDiaries() {
		List<DiaryResponse> diaries = new ArrayList<>();
		//매번 새로운 리스트 생성
		
		diaries.add(new DiaryResponse(
				"2026-01-28",
				"오늘은 자바를 공부했다."
				));
		
		diaries.add(new DiaryResponse(
				"2026-01-29",
				"오늘은 Spring Boot를 공부했다."
				));
		
		return diaries;
	}
	
	@PostMapping("/diary")
	//post는 서버에 데이터 저장하기
	//이 url(/diary)+post 요청이 오면 이 메서드를 실행해라
	public void createDiary(@RequestBody DiaryRequest request) {
		//@Requestbody는 JSON -> 자바 객체로 변환
		System.out.println(request.getDate());
		System.out.println(request.getContent());
	}
}
