package org.codejudge.sb.exception_handling;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
