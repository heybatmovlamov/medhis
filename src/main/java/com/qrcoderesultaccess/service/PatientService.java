package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.dto.response.LisReportsInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import java.util.List;

public interface PatientService {

    PatientResponse patientResponse();

    PatientInfoResponse getPatientInfoById(Integer id);

    List<LisReportsInfoResponse> lisReportsInfo(Integer id);
}
