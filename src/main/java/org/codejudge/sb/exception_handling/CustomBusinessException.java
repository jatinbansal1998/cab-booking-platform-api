package org.codejudge.sb.exception_handling;

public class CustomBusinessException extends RuntimeException {
    public CustomBusinessException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public CustomBusinessException(String errorMessage) {
        super(errorMessage);
    }
}
