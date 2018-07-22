package com.codetudes.dogeapi.service;

import com.codetudes.dogeapi.contract.WordDTO;

public interface WordService {
    WordDTO createWord(WordDTO wordDTO);

    WordDTO findWord(Long id);

    WordDTO updateWord(WordDTO wordDTO);

    Boolean deleteWord(Long id);
}
