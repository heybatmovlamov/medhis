package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;

public interface PatientService {
    PatientResponse patientResponse();
    PatientInfoResponse getPatientInfoById(Long id);
}
