package com.qrcoderesultaccess.controller;

import com.qrcoderesultaccess.dao.entity.PatientInfoDto;
import com.qrcoderesultaccess.model.dto.response.PatientResponse;
import com.qrcoderesultaccess.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientInfoDto> getPatientInfo(@PathVariable Long id) {
        PatientInfoDto dto = patientService.getPatientInfoById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
}
