package com.qrcoderesultaccess.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qrcoderesultaccess.model.enums.TimeEnum;
import java.time.LocalTime;
import lombok.Data;

@Data
public class TimeDto {

    private Integer requestedTime;

    @JsonProperty("started-time")
    private LocalTime startedTime;

    @JsonProperty("end-time")
    private LocalTime endTime;

    private TimeEnum timeEnum;
}
