package com.codetudes.dogeapi.db.repository;

import com.codetudes.dogeapi.db.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

}
