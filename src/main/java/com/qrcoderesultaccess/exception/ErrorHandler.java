package com.qrcoderesultaccess.exception;

import static com.qrcoderesultaccess.exception.constant.ErrorCode.PARAMETER_INVALID;
import static com.qrcoderesultaccess.exception.constant.ErrorMessage.INPUT_IS_INVALID;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.qrcoderesultaccess.exception.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@Component
@RequiredArgsConstructor
//@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorResponse handleBadRequestException(DataNotFoundException ex) {
        this.addErrorLog(NOT_FOUND, ex.getErrorCode(), ex.getMessage(), "DataNotFoundException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(NOT_ACCEPTABLE)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleBadRequestException(MethodArgumentTypeMismatchException ex) {
        this.addErrorLog(NOT_ACCEPTABLE, ex.getErrorCode(), ex.getMessage(), "MethodArgumentTypeMismatchException");
        return new ErrorResponse(ex.getErrorCode(), INPUT_IS_INVALID);
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(JsonDateTimeException.class)
    public ErrorResponse handleBadRequestException(JsonDateTimeException ex) {
        this.addErrorLog(CONFLICT, "404", ex.getMessage(), "JsonDateTimeException");
        return new ErrorResponse("404", PARAMETER_INVALID);
    }

    //*** Logging ***//
    protected void addErrorLog(HttpStatus httpStatus, String errorCode, String errorMessage, String exceptionType) {
        log.error("HttpStatus: {} | Code: {} | Type: {} | Message: {}", httpStatus, errorCode,
                exceptionType, errorMessage);
    }
}
