package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.config.CloudClient;
import com.qrcoderesultaccess.model.dto.response.CloudResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final CloudClient client;

    public Integer uploadToCloud(CloudResponse cloudResponse) {
        return client.uploadToCloud(cloudResponse);
    }
}
