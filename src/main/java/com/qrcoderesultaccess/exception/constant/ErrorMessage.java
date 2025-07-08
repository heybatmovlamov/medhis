package com.qrcoderesultaccess.exception.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessage {

    public static final String PATIENT_ID_NOT_FOUND = "Patient id not found.";
    public static final String INPUT_IS_INVALID = "Input is invalid.";
}
