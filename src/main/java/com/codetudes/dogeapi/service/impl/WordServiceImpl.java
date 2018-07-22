package com.codetudes.dogeapi.service.impl;

import com.codetudes.dogeapi.config.Mapper;
import com.codetudes.dogeapi.config.error.ResourceNotFoundException;
import com.codetudes.dogeapi.contract.WordDTO;
import com.codetudes.dogeapi.db.entity.Word;
import com.codetudes.dogeapi.db.repository.WordRepository;
import com.codetudes.dogeapi.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Autowired
    Mapper mapper;

    @Override
    public WordDTO createWord(WordDTO wordDTO) {
        Word word = mapper.map(wordDTO, Word.class);
        return mapper.map(wordRepository.save(word), WordDTO.class);
    }

    @Override
    public WordDTO findWord(Long id) {
        Optional<Word> word = wordRepository.findById(id);
        if (!word.isPresent()) {
            throw new ResourceNotFoundException();
        }

        return mapper.map(word.get(), WordDTO.class);
    }

    @Override
    public WordDTO updateWord(WordDTO wordDTO) {
        Optional<Word> word = wordRepository.findById(wordDTO.getId());
        if (!word.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Word oldEntity = word.get();
        mapper.map(wordDTO, oldEntity);

        Word newEntity = wordRepository.save(oldEntity);
        return mapper.map(oldEntity, WordDTO.class);

    }

    @Override
    public Boolean deleteWord(Long id) {
        if (wordRepository.existsById(id)) {
            wordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
