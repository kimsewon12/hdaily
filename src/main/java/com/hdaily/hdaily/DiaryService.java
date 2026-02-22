package com.hdaily.hdaily;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DiaryService {
	private List<DiaryResponse> diaries = new ArrayList<>();
	
	public DiaryService() {
		diaries.add(new DiaryResponse("2026-01-28","오늘은 자바를 공부했다."));
		diaries.add(new DiaryResponse("2026-01-29","오늘은 Spring Boot를 공부했다."));
	}
	
	public List<DiaryResponse> getAllDiaries(){
		return diaries;
	}
	
	public DiaryResponse getDiaryByDate(String targetDate) {
		for(DiaryResponse diary : diaries) {
			if(diary.getDate().equals(targetDate)) {
				return diary;
			}
		}
		return null;
	}
	
	public void createDiary(DiaryRequest request) {
		diaries.add(new DiaryResponse(request.getDate(),request.getContent()));
	}
}
