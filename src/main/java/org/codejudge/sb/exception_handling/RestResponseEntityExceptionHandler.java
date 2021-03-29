package org.codejudge.sb.exception_handling;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.mo.BaseResponseMO;
import org.codejudge.sb.mo.ErrorResponseMO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.codejudge.sb.constants.Status.FAILURE;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BaseResponseMO> customHandleAllException(Exception exception, WebRequest webRequest) {
        log.error(exception.getMessage());
        ErrorResponseMO errorResponseMO = ErrorResponseMO.builder()
                .status(FAILURE.getValue())
                .reason(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseMO);
    }
}
