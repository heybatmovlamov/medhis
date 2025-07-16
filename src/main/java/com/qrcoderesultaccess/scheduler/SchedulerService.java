package com.qrcoderesultaccess.scheduler;

import com.qrcoderesultaccess.service.factory.Factory;
import com.qrcoderesultaccess.service.strategy.SchedulerStrategy;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final Factory factory;

    @Scheduled(cron = "0 */3 * * * *")
    public void runScheduler() {
        LocalTime now = LocalTime.now();
        factory.getStrategy(now).ifPresent(SchedulerStrategy::execute);
        log.info("Running Scheduler " + now);
    }
}
