package com.example.springbootuploadfile.storage;

/**
 * Created by suneee on 2018/6/14.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
