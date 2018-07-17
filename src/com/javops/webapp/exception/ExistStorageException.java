package com.javops.webapp.exception;

/**
 * Created by TRACTEL_RND on 22.04.2018.
 */
public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume with uuid = " + uuid + " already exist", uuid);
    }
}
