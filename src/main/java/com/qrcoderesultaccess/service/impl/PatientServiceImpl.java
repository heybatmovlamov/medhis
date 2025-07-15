package com.qrcoderesultaccess.service.impl;

import static com.qrcoderesultaccess.exception.constant.ErrorMessage.PATIENT_ID_NOT_FOUND;

import com.qrcoderesultaccess.dao.repository.PatientRepository;
import com.qrcoderesultaccess.exception.DataNotFoundException;
import com.qrcoderesultaccess.model.dto.LisReportsInfoDto;
import com.qrcoderesultaccess.model.dto.PatientInfoDto;
import com.qrcoderesultaccess.model.dto.PatientsIdDto;
import com.qrcoderesultaccess.service.PatientService;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Override
    public PatientsIdDto patientResponse() {
        final Set<Integer> patientIds = repository.getPatientIds();
        if (patientIds.isEmpty()) {
            throw DataNotFoundException.of(PATIENT_ID_NOT_FOUND);
        }
        return PatientsIdDto.builder().id(patientIds).build();
    }

    @Override
    public PatientInfoDto getPatientInfoById(Integer id) {
        return  repository.getPatientInfo(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> DataNotFoundException.of(PATIENT_ID_NOT_FOUND));
    }

    @Override
    public List<LisReportsInfoDto> lisReportsInfo(Integer id) {
        final List<LisReportsInfoDto> newLisReport = repository.getNewLisReport(id);
        if (newLisReport.isEmpty()) {
            throw DataNotFoundException.of(PATIENT_ID_NOT_FOUND);
        }
        return newLisReport;
    }
}




