package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.dao.repository.PatientRepository;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    @Transactional(readOnly = true)
    public PatientResponse patientResponse() {
        return PatientResponse.builder().id(repository.getPatientIds()).build();
    }

}




