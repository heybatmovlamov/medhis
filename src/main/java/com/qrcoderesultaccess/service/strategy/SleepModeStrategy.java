package com.qrcoderesultaccess.service.strategy;

import static java.lang.Boolean.FALSE;

import java.time.LocalTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SleepModeStrategy implements SchedulerStrategy {

    @Override
    public List<Integer> execute() {
        return List.of();
    }

    @Override
    public Boolean shouldRun(LocalTime now) {
        log.info("Sleep mode running");
        return FALSE;
    }

    @Override
    public Boolean supports(LocalTime now) {
        log.info("Sleep mode supports : " + "22:00 - 8:00");
        return now.isAfter(LocalTime.of(22, 0)) && now.isBefore(LocalTime.of(8, 0));
    }
}
