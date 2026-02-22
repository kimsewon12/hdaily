package com.hdaily.hdaily;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DiaryController{
	
	private final DiaryService diaryService;
	
	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}
	
	@GetMapping("/diary")
	public List<DiaryResponse> getDiaries(){
		return diaryService.getAllDiaries();
	}
	@GetMapping("/diary/{date}")
	public DiaryResponse getDiary(@PathVariable ("date") String date) {
		return diaryService.getDiaryByDate(date);
	}
	
	@PostMapping("/diary")
	public void createDiary(@RequestBody DiaryRequest request) {
		diaryService.createDiary(request);
	}
	
}

