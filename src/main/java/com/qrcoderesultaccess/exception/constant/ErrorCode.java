package com.qrcoderesultaccess.exception.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorCode {

    public static final String ALREADY_EXIST = "already_exist";
    public static final String DATA_NOT_FOUND = "data_not_found";
    public static final String PARAMETER_INVALID = "parameter_invalid";
    public static final String REQUEST_INVALID = "request_body_invalid";
    public static final String PATH_VARIABLE_INVALID = "path_variable_invalid";
}
