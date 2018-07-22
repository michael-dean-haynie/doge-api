package com.codetudes.dogeapi.config.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(getErrorAttributes(ex, status), status);
    }

    private Map<String, Object> getErrorAttributes(RuntimeException ex, HttpStatus status){
        Map<String, Object> attributes = new TreeMap<>();
        attributes.put("timestamp", new Date());
        attributes.put("status", status);
        attributes.put("error", ex.getClass().getSimpleName());
        attributes.put("message", ex.getMessage());
        return attributes;
    }
}
