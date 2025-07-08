package com.qrcoderesultaccess.service.impl;

import static com.qrcoderesultaccess.exception.constant.ErrorMessage.PATIENT_ID_NOT_FOUND;

import com.qrcoderesultaccess.dao.repository.PatientRepository;
import com.qrcoderesultaccess.exception.DataNotFoundException;
import com.qrcoderesultaccess.model.dto.response.LisReportsInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import com.qrcoderesultaccess.service.PatientService;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Transactional(readOnly = true)
    @Override
    public PatientResponse patientResponse() {
        Set<Integer> patientIds = repository.getPatientIds();
        if (patientIds.isEmpty()) {
            throw DataNotFoundException.of(PATIENT_ID_NOT_FOUND);
        }
        return PatientResponse.builder().id(patientIds).build();
    }


    @Transactional(readOnly = true)
    @Override
    public PatientInfoResponse getPatientInfoById(Long id) {
        PatientInfoResponse patientInfoDto = repository.getPatientInfo(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> DataNotFoundException.of(PATIENT_ID_NOT_FOUND));
        return patientInfoDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<LisReportsInfoResponse> lisReportsInfo(Long id) {
        List<LisReportsInfoResponse> newLisReport = repository.getNewLisReport(id);
        if (newLisReport.isEmpty()) {
            throw DataNotFoundException.of(PATIENT_ID_NOT_FOUND);
        }
        return newLisReport;
    }


}




