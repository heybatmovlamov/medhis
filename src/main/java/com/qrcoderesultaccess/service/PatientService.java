package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.dao.entity.PatientInfoDto;
import com.qrcoderesultaccess.dao.repository.PatientRepository;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository repository;

    @Transactional(readOnly = true)
    public PatientResponse patientResponse() {
        return PatientResponse.builder().id(repository.getPatientIds()).build();
    }


    @Transactional(readOnly = true)
    public PatientInfoDto getPatientInfoById(Long id) {
        PatientInfoDto patientInfoDto = repository.getPatientInfo(id)
                .stream()
                .findFirst()
                .orElse(null);
        log.info(patientInfoDto.toString());
        return patientInfoDto;
    }

}




