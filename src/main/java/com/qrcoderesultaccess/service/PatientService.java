package com.qrcoderesultaccess.service;

import static com.qrcoderesultaccess.exception.constant.ErrorMessage.PATIENT_ID_NOT_FOUND;

import com.qrcoderesultaccess.dao.repository.PatientRepository;
import com.qrcoderesultaccess.exception.DataNotFoundException;
import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    @Transactional(readOnly = true)
    public PatientResponse patientResponse() {
        Set<Integer> patientIds = repository.getPatientIds();
        if (patientIds.isEmpty()) {
            throw DataNotFoundException.of(PATIENT_ID_NOT_FOUND);
        }
        return PatientResponse.builder().id(patientIds).build();
    }


    @Transactional(readOnly = true)
    public PatientInfoResponse getPatientInfoById(Long id) {
        PatientInfoResponse patientInfoDto = repository.getPatientInfo(id)
                .stream()
                .findFirst()
                .orElse(null);
        log.info(patientInfoDto.toString());
        return patientInfoDto;
    }

}




