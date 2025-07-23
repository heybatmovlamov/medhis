package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.dto.CloudDto;
import java.util.List;

public interface ClientService {
    List<Integer> uploadToCloud(CloudDto cloudDto);
}
