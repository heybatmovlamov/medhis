package com.qrcoderesultaccess.service.factory;

import com.qrcoderesultaccess.service.strategy.SchedulerStrategy;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerStrategyFactory implements Factory {

    private final List<SchedulerStrategy> strategies;

    @Override
    public Optional<SchedulerStrategy> getStrategy(LocalTime now) {
        return strategies.stream()
                .filter(s -> s.supports(now))
                .filter(s -> s.shouldRun(now))
                .findFirst();
    }
}
