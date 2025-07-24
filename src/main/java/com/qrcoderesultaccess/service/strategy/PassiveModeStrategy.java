package com.qrcoderesultaccess.service.strategy;

import com.qrcoderesultaccess.model.dto.CloudDto;
import com.qrcoderesultaccess.service.ClientService;
import com.qrcoderesultaccess.service.DbFetcherService;
import com.qrcoderesultaccess.service.JsonReaderService;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PassiveModeStrategy implements SchedulerStrategy {

    private final DbFetcherService fetcherService;
    private final ClientService clientService;
    private final JsonReaderService jsonReaderService;

    @Override
    public List<Integer> execute() {
        CloudDto response = fetcherService.fetchDbData();
        List<Integer> integers = clientService.uploadToCloud(response);
        log.info(integers.toString());
        return integers;
    }

    @Override
    public Boolean shouldRun(LocalTime now) {
        log.info("Passive mode running");
        return now.getMinute() % 15 == 0;
    }

    @Override
    public Boolean supports(LocalTime now) {
        return jsonReaderService.supportedTime(1, now);
    }
}
