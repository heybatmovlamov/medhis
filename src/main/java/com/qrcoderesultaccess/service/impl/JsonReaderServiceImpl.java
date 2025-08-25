package com.qrcoderesultaccess.service.impl;

import com.qrcoderesultaccess.config.MyConfigProperties;
import com.qrcoderesultaccess.config.TimeSlotConfig;
import com.qrcoderesultaccess.model.enums.TimeEnum;
import com.qrcoderesultaccess.service.JsonReaderService;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonReaderServiceImpl implements JsonReaderService {

    private final MyConfigProperties myConfigProperties;

    @Override
    public Boolean shouldRun(TimeEnum mode, LocalTime now) {
        Integer requestedTime = myConfigProperties.getTimeSlots().stream()
                .filter(slot -> slot.getTimeEnum() == mode)
                .map(TimeSlotConfig::getRequestedTime)
                .findFirst()
                .orElse(null);

        if (requestedTime == null) {
            return false;
        }

        return now.getMinute() % requestedTime == 0;
    }

    @Override
    public Boolean supportedTime(TimeEnum mode, LocalTime now) {
        return myConfigProperties.getTimeSlots().stream()
                .filter(slot -> slot.getTimeEnum() == mode)
                .anyMatch(slot -> isInTimeRange(now, slot.getStartedTime(), slot.getEndTime()));
    }

    private boolean isInTimeRange(LocalTime now, String start, String end) {
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(end);

        if (endTime.isAfter(startTime)) {
            return !now.isBefore(startTime) && now.isBefore(endTime);
        } else {
            // Gecə dövrü (22:00 - 08:00 kimi)
            return !now.isBefore(startTime) || now.isBefore(endTime);
        }
    }

}
