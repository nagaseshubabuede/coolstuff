package com.example.springboottesting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAllExceptions(Exception e, HttpServletRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(ZoneOffset.UTC),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage(),
                e.getStackTrace() != null ? Arrays.asList(e.getStackTrace()).toString() : null,
                request.getServletPath()
        );
        return buildResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorMessage> handleDaoException(ServiceException exp, HttpServletRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(ZoneOffset.UTC),
                exp.getHttpStatus().value(),
                exp.getHttpStatus().getReasonPhrase(),
                exp.getMessage(),
                null,
                request.getServletPath()
        );
        return buildResponseEntity(errorMessage, exp.getHttpStatus());
    }

    private ResponseEntity<ErrorMessage> buildResponseEntity(ErrorMessage errorMessage, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON).body(errorMessage);
    }

}
