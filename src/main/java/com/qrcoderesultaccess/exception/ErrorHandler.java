package com.qrcoderesultaccess.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.qrcoderesultaccess.exception.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@Component
@RequiredArgsConstructor
//@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorResponse handleBadRequestException(DataNotFoundException ex) {
        this.addErrorLog(BAD_REQUEST, ex.getErrorCode(), ex.getMessage(), "BadRequestException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }


    //*** Logging ***//
    protected void addErrorLog(HttpStatus httpStatus, String errorCode, String errorMessage, String exceptionType) {
        log.error("HttpStatus: {} | Code: {} | Type: {} | Message: {}", httpStatus, errorCode,
                exceptionType, errorMessage);
    }

    protected void addErrorLog(HttpStatus httpStatus, String errorCode, String errorMessage, Throwable ex) {
        log.error("[Error] | Status: {} | Code: {} | Type: {} | Message: {}",
                httpStatus, errorCode, ex.getClass().getTypeName(), errorMessage, ex);
    }
}
