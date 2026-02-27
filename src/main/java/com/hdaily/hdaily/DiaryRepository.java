package com.hdaily.hdaily;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long>{ 
	Optional<Diary>findByDate(String date);
}
