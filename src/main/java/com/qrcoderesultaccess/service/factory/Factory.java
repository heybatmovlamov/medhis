package com.qrcoderesultaccess.service.factory;

import com.qrcoderesultaccess.service.strategy.SchedulerStrategy;
import java.time.LocalTime;
import java.util.Optional;

public interface Factory {

    Optional<SchedulerStrategy> getStrategy(LocalTime now);
}
