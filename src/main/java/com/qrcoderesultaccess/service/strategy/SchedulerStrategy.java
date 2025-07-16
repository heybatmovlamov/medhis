package com.qrcoderesultaccess.service.strategy;

import java.time.LocalTime;
import java.util.List;

public interface SchedulerStrategy {

    List<Integer> execute();

    Boolean shouldRun(LocalTime now);

    Boolean supports(LocalTime now);
}
