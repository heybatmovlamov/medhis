package com.qrcoderesultaccess.service.strategy;

import static java.lang.Boolean.FALSE;

import com.qrcoderesultaccess.model.dto.response.CloudResponse;
import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SleepModeStrategy implements SchedulerStrategy {

    @Override
    public CloudResponse execute() {
        return CloudResponse.builder().build();
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
