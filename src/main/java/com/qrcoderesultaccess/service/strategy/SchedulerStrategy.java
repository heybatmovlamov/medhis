package com.qrcoderesultaccess.service.strategy;

import com.qrcoderesultaccess.model.enums.TimeEnum;
import java.time.LocalTime;
import java.util.List;

public interface SchedulerStrategy {

    List<Integer> execute();

    Boolean shouldRun(LocalTime now);

    Boolean supports(LocalTime now);

//    TimeEnum getMode();
}
