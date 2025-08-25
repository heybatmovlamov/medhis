package com.qrcoderesultaccess.service.strategy;

import static java.lang.Boolean.FALSE;

import com.qrcoderesultaccess.model.enums.TimeEnum;
import com.qrcoderesultaccess.service.JsonReaderService;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SleepModeStrategy implements SchedulerStrategy {

    private final JsonReaderService jsonReaderService;

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
        return jsonReaderService.supportedTime(TimeEnum.SLEEP, now);
    }

//    @Override
//    public TimeEnum getMode() {
//        return TimeEnum.SLEEP;
//    }
}
