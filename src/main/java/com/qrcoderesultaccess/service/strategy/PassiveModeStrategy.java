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
public class PassiveModeStrategy implements SchedulerStrategy {

    private final DbFetcherService dbFetcherService;

    @Override
    public CloudResponse execute() {
        return dbFetcherService.fetchDbData();
    }

    @Override
    public Boolean shouldRun(LocalTime now) {
        log.info("Passive mode running");
        return now.getMinute() % 15 == 0;
    }

    @Override
    public Boolean supports(LocalTime now) {
        log.info("Passive mode supports : " + "16:00 - 22:00");
        return now.isAfter(LocalTime.of(16, 0)) && now.isBefore(LocalTime.of(22, 0));
    }
}
