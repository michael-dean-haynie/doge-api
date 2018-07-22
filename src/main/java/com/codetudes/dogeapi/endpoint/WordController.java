package com.codetudes.dogeapi.endpoint;

import com.codetudes.dogeapi.config.error.ResourceNotFoundException;
import com.codetudes.dogeapi.contract.WordDTO;
import com.codetudes.dogeapi.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("word")
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping
    public WordDTO createWord(@RequestBody WordDTO wordDTO) {
        return wordService.createWord(wordDTO);
    }

    @GetMapping("{id}")
    public WordDTO getWord(@PathVariable("id") Long id) {
        return wordService.findWord(id);
    }

    @PatchMapping
    public WordDTO updateWord(@RequestBody WordDTO wordDTO) {
        return wordService.updateWord(wordDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteWord(@PathVariable("id") Long id) {

        if (wordService.deleteWord(id)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
