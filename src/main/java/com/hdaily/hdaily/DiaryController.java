package com.hdaily.hdaily;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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
	public void createDiary(@RequestBody DiaryRequest request) {//@RequestBody는 입력으로 들어온 json을 자동으로 DiaryRequest형식으로 고쳐줌
		diaryService.createDiary(request);
	}
	
	@PutMapping("/diary/{date}")
	public void updateDiary(@PathVariable("date") String date, @RequestBody DiaryRequest request) {
		diaryService.updateDiary(date, request);
	}
	
	@DeleteMapping("/diary/{date}")
	public void deleteDiary(@PathVariable("date") String date) {
		diaryService.deleteDiary(date);
	}
	
}

