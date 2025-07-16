package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.config.CloudClient;
import com.qrcoderesultaccess.model.dto.CloudDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final CloudClient client;

    public List<Integer> uploadToCloud(CloudDto cloudDto) {
        return client.uploadToCloud(cloudDto);
    }
}
