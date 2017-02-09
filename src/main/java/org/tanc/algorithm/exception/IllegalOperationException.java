package org.tanc.algorithm.exception;

/**
 * 非法操作异常
 * Created by tanc on 2017/2/9.
 */
public class IllegalOperationException extends RuntimeException {

    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }
}
