package com.codetudes.dogeapi.config.error;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Requested resource could not be found");
    }
}
