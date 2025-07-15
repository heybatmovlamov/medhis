package com.qrcoderesultaccess.config;

import com.qrcoderesultaccess.model.dto.CloudDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-cloud", url = "http://192.168.0.165:8080/api/v1")
public interface CloudClient {

    @PostMapping("/cloud-lis/upload")
    Integer uploadToCloud(@RequestBody CloudDto request);
}
