package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.dto.response.CloudResponse;
import com.qrcoderesultaccess.model.dto.response.LisReportsInfoResponse;
import com.qrcoderesultaccess.model.dto.response.LocalResponse;
import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DbFetcherService {

    private final PatientService patientService;

    public CloudResponse fetchDbData() {
        CloudResponse cloudResponse = CloudResponse.builder().build();

        Set<Integer> ids = patientService.patientResponse().getId();

        ids.forEach(id -> {
            PatientInfoResponse patientInfoById = patientService.getPatientInfoById(id);
            List<LisReportsInfoResponse> lisReportsInfoResponses = patientService.lisReportsInfo(id);
            LocalResponse json = LocalResponse.builder()
                    .id(id)
                    .patientInfo(patientInfoById)
                    .lisReportsInfo(lisReportsInfoResponses)
                    .build();
            cloudResponse.getCloudResponseList().add(json);
        });

        log.info(cloudResponse.toString());
        return cloudResponse;
    }
}
