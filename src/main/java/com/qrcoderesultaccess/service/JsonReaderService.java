package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.enums.TimeEnum;
import java.time.LocalTime;

public interface JsonReaderService {

    Boolean shouldRun(TimeEnum mode, LocalTime now);

    Boolean supportedTime(TimeEnum mode, LocalTime now);
}