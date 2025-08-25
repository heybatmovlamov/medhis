package com.qrcoderesultaccess.config;

import com.qrcoderesultaccess.model.enums.TimeEnum;
import lombok.Data;

@Data
public class TimeSlotConfig {
    private Integer requestedTime;
    private String startedTime;
    private String endTime;
    private TimeEnum timeEnum;
}
