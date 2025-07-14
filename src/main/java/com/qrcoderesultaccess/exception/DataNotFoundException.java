package com.qrcoderesultaccess.exception;

import com.qrcoderesultaccess.exception.constant.ErrorCode;
import java.text.MessageFormat;

public class DataNotFoundException extends CommonException {

    public DataNotFoundException(String message) {
        super(ErrorCode.DATA_NOT_FOUND, message);
    }

    public static DataNotFoundException of(String message, Object... args) {
        return new DataNotFoundException(MessageFormat.format(message, args));
    }
}