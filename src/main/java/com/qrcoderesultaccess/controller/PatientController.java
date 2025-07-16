package com.qrcoderesultaccess.controller;

import com.qrcoderesultaccess.model.dto.LisReportsInfoDto;
import com.qrcoderesultaccess.model.dto.PatientInfoDto;
import com.qrcoderesultaccess.model.dto.PatientsIdDto;
import com.qrcoderesultaccess.service.PatientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PatientController {

    private final PatientService service;

    @GetMapping("/patients")
    public ResponseEntity<PatientsIdDto> getPatients() {
        return ResponseEntity.ok(service.patientResponse());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientInfoDto> getPatientInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPatientInfoById(id));
    }

    @GetMapping("/patients/{id}/lis-reports")
    public ResponseEntity<List<LisReportsInfoDto>> getPatientInfoLis(@PathVariable Integer id) {
        return ResponseEntity.ok(service.lisReportsInfo(id));
    }
}
