package com.qrcoderesultaccess.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qrcoderesultaccess.model.dto.TimeDto;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonReaderService {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    private List<TimeDto> readPersonJson() {
        Resource resource = resourceLoader.getResource("classpath:data/time-settings.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean supportedTime(Integer integer, LocalTime now) {
        TimeDto time = readPersonJson().get(integer);

        int startDateHour = time.getStartedTime().getHour();
        int startDateMinute = time.getStartedTime().getMinute();
        int endDateHour = time.getEndTime().getHour();
        int endDateMinute = time.getEndTime().getMinute();

        return now.isAfter(LocalTime.of(startDateHour, startDateMinute))
                && now.isBefore(LocalTime.of(endDateHour, endDateMinute));
    }

}