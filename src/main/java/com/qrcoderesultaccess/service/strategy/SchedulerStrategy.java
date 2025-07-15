package com.qrcoderesultaccess.service.strategy;

import java.time.LocalTime;

public interface SchedulerStrategy {

    Integer execute();

    Boolean shouldRun(LocalTime now);

    Boolean supports(LocalTime now);
}
