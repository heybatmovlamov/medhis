package com.qrcoderesultaccess.controller;

import com.qrcoderesultaccess.model.dto.response.CloudResponse;
import com.qrcoderesultaccess.model.dto.response.LisReportsInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientInfoResponse;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import com.qrcoderesultaccess.service.impl.PatientServiceImpl;
import com.qrcoderesultaccess.service.strategy.ActiveModeStrategy;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PatientController {

    private final PatientServiceImpl patientServiceImpl;
    private final ActiveModeStrategy activeModeStrategy;

    @GetMapping("/patients")
    public ResponseEntity<PatientResponse> getPatients() {
        return ResponseEntity.ok(patientServiceImpl.patientResponse());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientInfoResponse> getPatientInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(patientServiceImpl.getPatientInfoById(id));
    }

    @GetMapping("/patients/{id}/lis-reports")
    public ResponseEntity<List<LisReportsInfoResponse>> getPatientInfoLis(@PathVariable Integer id) {
        return ResponseEntity.ok(patientServiceImpl.lisReportsInfo(id));
    }

    @PostMapping("/test")
    public ResponseEntity<CloudResponse> testPatient() {
        return ResponseEntity.ok(activeModeStrategy.execute());
    }
}
