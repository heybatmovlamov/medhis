package com.qrcoderesultaccess.service;

import com.qrcoderesultaccess.model.dto.LisReportsInfoDto;
import com.qrcoderesultaccess.model.dto.PatientInfoDto;
import com.qrcoderesultaccess.model.dto.PatientsIdDto;
import java.util.List;

public interface PatientService {

    PatientsIdDto patientResponse();

    PatientInfoDto getPatientInfoById(Integer id);

    List<LisReportsInfoDto> lisReportsInfo(Integer id);
}
