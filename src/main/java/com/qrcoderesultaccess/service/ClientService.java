package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.config.CloudClient;
import com.qrcoderesultaccess.model.dto.CloudDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final CloudClient client;

    public Integer uploadToCloud(CloudDto cloudDto) {
        return client.uploadToCloud(cloudDto);
    }
}
