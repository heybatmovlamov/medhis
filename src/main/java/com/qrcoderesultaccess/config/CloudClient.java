package com.qrcoderesultaccess.config;

import com.qrcoderesultaccess.model.dto.CloudDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ms-cloud", url = "localhost:8085/api/v1")
public interface CloudClient {

    @PostMapping("/upload")
    List<Integer> uploadToCloud(
            @RequestHeader("X-Clinic-Id") String clinicId,
            @RequestHeader("X-Timestamp") String timestamp,
            @RequestHeader("X-Nonce") String nonce,
            @RequestHeader("X-Public-Key") String publicKey,
            @RequestHeader("X-Encrypted-Key") String encryptedKey,
            @RequestBody CloudDto request
    );

}
