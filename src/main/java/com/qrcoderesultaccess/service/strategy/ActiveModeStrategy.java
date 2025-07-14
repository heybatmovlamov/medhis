package com.qrcoderesultaccess.service.strategy;

import com.qrcoderesultaccess.model.dto.response.CloudResponse;
import com.qrcoderesultaccess.service.DbFetcherService;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActiveModeStrategy implements SchedulerStrategy {

    private final DbFetcherService dbFetcherService;

    @Override
    public CloudResponse execute() {
        return dbFetcherService.fetchDbData();
    }

    @Override
    public Boolean shouldRun(LocalTime now) {
        log.info("Active mode running");
        return now.getMinute() % 3 == 0;
    }

    @Override
    public Boolean supports(LocalTime now) {
        log.info("Active mode supports : " + "8:00 - 16:00");
        return now.isAfter(LocalTime.of(8, 0)) && now.isBefore(LocalTime.of(16, 0));
    }
}
