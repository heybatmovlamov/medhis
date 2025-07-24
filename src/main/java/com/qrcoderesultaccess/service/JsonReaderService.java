package com.qrcoderesultaccess.service;

import java.time.LocalTime;

public interface JsonReaderService {
    Boolean supportedTime(Integer integer, LocalTime now);
    Boolean shouldRun(Integer requestTime, LocalTime now);
}
