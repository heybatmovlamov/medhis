package com.qrcoderesultaccess.config;

import com.qrcoderesultaccess.model.dto.CloudDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-cloud", url = "localhost:8085/api/v1")
public interface CloudClient {

    @PostMapping("/upload")
    List<Integer> uploadToCloud(@RequestBody CloudDto request);
}
