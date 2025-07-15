package com.qrcoderesultaccess.service.impl;

import com.qrcoderesultaccess.model.dto.CloudDto;
import com.qrcoderesultaccess.model.dto.LisReportsInfoDto;
import com.qrcoderesultaccess.model.dto.LocalDto;
import com.qrcoderesultaccess.model.dto.PatientInfoDto;
import com.qrcoderesultaccess.service.DbFetcherService;
import com.qrcoderesultaccess.service.PatientService;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DbFetcherServiceImpl implements DbFetcherService {

    private final PatientService patientService;

    @Override
    public CloudDto fetchDbData() {
        CloudDto cloudDto = CloudDto.builder().build();

        Set<Integer> ids = patientService.patientResponse().getId();

        ids.forEach(id -> {
            PatientInfoDto patientInfoById = patientService.getPatientInfoById(id);
            List<LisReportsInfoDto> lisReportsInfoRespons = patientService.lisReportsInfo(id);
            LocalDto json = LocalDto.builder()
                    .id(id)
                    .patientInfo(patientInfoById)
                    .lisReportsInfo(lisReportsInfoRespons)
                    .build();
            cloudDto.getCloudResponseList().add(json);
        });

        log.info(cloudDto.toString());
        return cloudDto;
    }
}
