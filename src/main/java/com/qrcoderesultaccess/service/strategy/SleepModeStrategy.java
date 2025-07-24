package com.qrcoderesultaccess.service.strategy;

import static java.lang.Boolean.FALSE;

import com.qrcoderesultaccess.service.impl.JsonReaderServiceImpl;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SleepModeStrategy implements SchedulerStrategy {

    private final JsonReaderServiceImpl jsonReaderServiceImpl;

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
        return jsonReaderServiceImpl.supportedTime(2, now);
    }
}
