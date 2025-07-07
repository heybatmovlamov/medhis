package com.qrcoderesultaccess.controller;

import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import com.qrcoderesultaccess.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<PatientResponse> getPatients() {
        return ResponseEntity.ok(patientService.patientResponse());
    }
}
