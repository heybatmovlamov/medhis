package com.qrcoderesultaccess.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoResponse {
    private String patientName;
    private String secretCode;
    private String qrCode;
}
