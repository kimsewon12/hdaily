package com.hdaily.hdaily;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DiaryService {
	
	private final DiaryRepository diaryRepository;
	
	public DiaryService(DiaryRepository diaryRepository) {
		this.diaryRepository = diaryRepository;
	}
	
	public void createDiary(DiaryRequest request) {
		Diary newDiary = new Diary(request.getDate(),request.getContent());
		
		diaryRepository.save(newDiary);
	}
	
	public List<DiaryResponse> getAllDiaries(){
		List<Diary> diaries = diaryRepository.findAll();
		
		List<DiaryResponse> responses = new ArrayList<>();
		for(Diary diary: diaries) {
			responses.add(new DiaryResponse(diary.getDate(),diary.getContent()));
		}
		return responses;
	}
	
	public DiaryResponse getDiaryByDate(String targetDate) {
		
		Diary diary = diaryRepository.findByDate(targetDate)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 날짜의 일기가 없습니다."));
		return new DiaryResponse(diary.getDate(),diary.getContent());
	}
	
}
