package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.dao.entity.PatientInfoDto;
import com.qrcoderesultaccess.dao.repository.PatientRepository;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
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




