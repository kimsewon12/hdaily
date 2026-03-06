package com.hdaily.hdaily;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DiaryRepositoryTest {
	
	@Autowired
	DiaryRepository diaryRepository;
	
	@Test
	void savingTest() {
		Diary diary = new Diary("2026-03-05","JUnit 첫 테스트");
		
		Diary savedDiary = diaryRepository.save(diary);
		
		assertThat(savedDiary.getContent()).isEqualTo("JUnit 첫 테스트");
	}
}