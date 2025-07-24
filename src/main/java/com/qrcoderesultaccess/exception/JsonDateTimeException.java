package com.qrcoderesultaccess.exception;

import com.qrcoderesultaccess.exception.constant.ErrorCode;
import java.io.IOException;
import java.text.MessageFormat;

public class JsonDateTimeException extends IOException {

    public JsonDateTimeException(String message) {
        super(ErrorCode.PARAMETER_INVALID);
    }

    public static JsonDateTimeException of(String message, Object... args) {
        return new JsonDateTimeException(MessageFormat.format(message, args));
    }
}
