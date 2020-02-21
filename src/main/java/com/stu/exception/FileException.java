package com.stu.exception;

/**
 * ClassName：FileException
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/10 11:49
 * @version 1.0.0
 */
public class FileException extends RuntimeException {
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
