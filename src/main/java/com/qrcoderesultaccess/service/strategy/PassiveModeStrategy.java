package com.qrcoderesultaccess.service.strategy;

import com.qrcoderesultaccess.config.CloudClient;
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

    private final DbFetcherService fetcherService;
    private final CloudClient client;

    @Override
    public Integer execute() {
        CloudResponse response = fetcherService.fetchDbData();
        return client.uploadToCloud(response);
    }

    @Override
    public Boolean shouldRun(LocalTime now) {
        log.info("Passive mode running");
        return now.getMinute() % 2 == 0;
    }

    @Override
    public Boolean supports(LocalTime now) {
        log.info("Passive mode supports : " + "16:00 - 22:00");
        return now.isAfter(LocalTime.of(16, 0)) && now.isBefore(LocalTime.of(22, 0));
    }
}
