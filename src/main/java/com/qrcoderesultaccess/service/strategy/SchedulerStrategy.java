package com.qrcoderesultaccess.service.strategy;

import com.qrcoderesultaccess.model.dto.response.CloudResponse;
import java.time.LocalTime;

public interface SchedulerStrategy {

    CloudResponse execute();

    Boolean shouldRun(LocalTime now);

    Boolean supports(LocalTime now);
}
