package com.qrcoderesultaccess.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mode-config")
public class MyConfigProperties {
    private List<TimeSlotConfig> timeSlots;
}
