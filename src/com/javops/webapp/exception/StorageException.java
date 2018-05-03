package com.javops.webapp.exception;

/**
 * Created by TRACTEL_RND on 22.04.2018.
 */
public class StorageException extends RuntimeException {

    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
