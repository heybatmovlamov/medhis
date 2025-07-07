package com.qrcoderesultaccess.exception;

import com.qrcoderesultaccess.exception.constant.ErrorCode;
import java.text.MessageFormat;

public class InvalidInputException extends CommonException {

    public InvalidInputException(String message) {
        super(ErrorCode.PARAMETER_INVALID, message);
    }

    public static InvalidInputException of(String message, Object... args) {
        return new InvalidInputException(MessageFormat.format(message, args));
    }
}
